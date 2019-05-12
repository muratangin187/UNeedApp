package com.example.uneed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.uneed.network.AddItemRequest;
import com.example.uneed.network.PerformNetworkRequest;
import com.example.uneed.network.RegisterRequest;
import com.example.uneed.structures.GlobalData;

import java.util.HashMap;

import static com.example.uneed.MainActivity.CODE_POST_REQUEST;

/**
 * This class adds items to the database
 * @author fistikci_sahap
 * @version 3.0
 */
public class addItemActivity extends AppCompatActivity {

    public EditText title;
    public EditText price;
    public EditText description;
    public Spinner category;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        title = (EditText)findViewById(R.id.add_item_title);
        price = (EditText)findViewById(R.id.add_item_price);
        description = (EditText)findViewById(R.id.add_item_description);
        category = (Spinner)findViewById(R.id.spinner);
    }


    /**
     * This method creates  new item and sends it to the database
     * @param view
     */
    public void addItem(View view)
    {
        HashMap<String, String> params = new HashMap<>();
        params.put("userid", String.valueOf(((GlobalData)this.getApplication()).getVariable()));
        params.put("title", String.valueOf(title.getText()));
        params.put("photourl", "https://i.dr.com.tr/cache/600x600-0/originals/0001793197001-1.jpg");
        params.put("price",String.valueOf(price.getText()));
        params.put("description",String.valueOf(description.getText()));
        params.put("category_id",String.valueOf(category.getSelectedItemPosition()));
        PerformNetworkRequest request;
        request = new AddItemRequest(Api.URL_ADD_ITEM, params, CODE_POST_REQUEST);
        request.execute();
    }

    /**
     * This method closes the addItemActivity and initiates MarketActivity class
     * @param view
     */
    public void closeAddItem(View view)
    {
        Intent i = new Intent(this, MarketActivity.class);
//        i.putExtra("sort_id", radioSort.getCheckedRadioButtonId());
        startActivity(i);
        finish();
    }
}
