package com.example.uneed;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.uneed.network.GetMessagesRequest;
import com.example.uneed.network.PerformNetworkRequest;
import com.example.uneed.network.SendMessageRequest;
import com.example.uneed.structures.ChatArrayAdapter;
import com.example.uneed.structures.ChatMessage;
import com.example.uneed.structures.GlobalData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.uneed.MainActivity.CODE_POST_REQUEST;

/**
 * This class is a chat activity class. 
 * When users start messaging with each other 
 * this class sends and receives the messages from database.
 * @author fistikci_sahap
 * @version 2.0
 */
public class MessageActivity extends AppCompatActivity
{
    public static ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    private ImageButton buttonSend;
    private boolean side = false;
    private int from_id;
    private int to_id;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        buttonSend = findViewById(R.id.send);

        listView = (ListView) findViewById(R.id.msgview);
        Intent intent = getIntent();
        from_id = ((GlobalData)this.getApplication()).getVariable();
        to_id = intent.getExtras().getInt("to_id");
        //Log.i("M",String.valueOf(to_id));
        //to_id = 2;
        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.right);
        listView.setAdapter(chatArrayAdapter);

        chatText = (EditText) findViewById(R.id.msg);
        chatText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    return sendChatMessage();
                }
                return false;
            }
        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sendChatMessage();
            }
        });

        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(chatArrayAdapter);

        //to scroll the list view to bottom on data change
        chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatArrayAdapter.getCount() - 1);
            }
        });

        final Handler handler = new Handler();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        HashMap<String, String> params = new HashMap<>();

                        params.put("fromid", String.valueOf(from_id));
                        params.put("toid", String.valueOf(to_id));
                        //Log.i("HAYOF",params.toString());
                        PerformNetworkRequest request = (PerformNetworkRequest)(new GetMessagesRequest(Api.URL_GET_MESSAGES,params,CODE_POST_REQUEST)).execute();

                    }
                });
            }
        };

        timer = new Timer();

        timer.schedule(timerTask,1000,3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
    }

    /**
     * This method is for sending message to an another user
     * @return true if user send the message, false otherwise 
     */
    public boolean sendChatMessage() {
        if (TextUtils.isEmpty(chatText.getText())) { // If message box is empty
            chatText.setError("Please enter message");
            chatText.requestFocus();
            return false;
        }
        String result = "";
        int counter = 0;
        for(int i = 0; i < chatText.getText().toString().length(); i++)
        {
            counter++;
            result += chatText.getText().toString().charAt(i);
            if( counter > 30 && chatText.getText().toString().charAt(i) == ' ') // if the message is long
            {
                result += "\n";
                counter = 0;
            }
        }
        ChatMessage newMessage = new ChatMessage(result, getDate(), ((GlobalData)this.getApplication()).getVariable(), to_id);
        newMessage.setLeft(true); // message seen in the left side of the panel
        chatArrayAdapter.add(newMessage);
        HashMap<String, String> params = new HashMap<>();
        params.put("fromid", String.valueOf(newMessage.from_id));
        params.put("toid", String.valueOf(newMessage.to_id));
        params.put("message", newMessage.message);

        PerformNetworkRequest request;
        //Calling the create user API
        request = new SendMessageRequest(Api.URL_SEND_MESSAGES, params, CODE_POST_REQUEST);
        request.execute();
        chatText.setText("");
        return true;
    }

    /**
     * This method returns date and time of the message
     * @return String
     */
    private String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        //Log.i("DATE", currentDateandTime);
        return currentDateandTime;
    }
}
