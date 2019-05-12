package com.example.uneed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.uneed.network.CheckMessageBoxRequest;
import com.example.uneed.network.GetMessagesRequest;
import com.example.uneed.network.PerformNetworkRequest;
import com.example.uneed.structures.GlobalData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.example.uneed.MainActivity.CODE_POST_REQUEST;

public class MessageBox extends AppCompatActivity {

    ListView messageBoxList;
    static public ArrayAdapter<String> listAdapter ;
    static public ArrayList<Integer> user_ids;
    private int from_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_box);
        messageBoxList = (ListView)findViewById(R.id.messageBoxList);

        Intent intent = getIntent();
        from_id = ((GlobalData)this.getApplication()).getVariable();
        HashMap<String, String> params = new HashMap<>();

        params.put("fromid", String.valueOf(from_id));
        Log.i("deneme",params.get("fromid"));
        PerformNetworkRequest request = (PerformNetworkRequest)(new CheckMessageBoxRequest(Api.URL_GET_ALL_MESSAGES,params,CODE_POST_REQUEST)).execute();


        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow);

        // Set the ArrayAdapter as the ListView's adapter.
        messageBoxList.setAdapter( listAdapter );
        final Intent i = new Intent(this, MessageActivity.class);
        messageBoxList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (parent.getItemAtPosition(position).toString());
                selectedItem = selectedItem.substring(0,selectedItem.indexOf(" "));
                Log.i("ASD", selectedItem);
                i.putExtra("to_id", Integer.valueOf(selectedItem));
                startActivity(i);
            }
        });
    }
}
