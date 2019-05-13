package com.example.uneed.network;

import android.util.Log;

import com.example.uneed.MainActivity;
import com.example.uneed.MessageActivity;
import com.example.uneed.structures.ChatArrayAdapter;
import com.example.uneed.structures.ChatMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * This class send request to the server
 * in order to get messages from the database
 * @author  fistikci_sahap
 * @version 1.0
 * */
public class GetMessagesRequest extends PerformNetworkRequest
{
    boolean isFinished = false;
    static JSONObject old = null;
    public GetMessagesRequest(String url, HashMap<String, String> params, int requestCode)
    {
        super(url, params, requestCode);
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        JSONObject messagesJson = null;
        try
        {
            //Log.i("TMP",result.toString());
            if(old == null)
                old = result;
            Log.i("CHECK",String.valueOf(old == result));
            Log.i("CHECK DATA old:",old.toString(2));
            Log.i("CHECK DATA result:",result.toString(2));
            MessageActivity.chatArrayAdapter.clear();
            for(int i = 0; i < result.length()-1; i++)
            {
                messagesJson = result.getJSONObject(String.valueOf(i));
                //Log.i("BAK", messagesJson.toString());
                ChatMessage message = new ChatMessage(messagesJson.getString("message"),messagesJson.getString("date"),messagesJson.getInt("from_id"),messagesJson.getInt("to_id"));
                message.setId(messagesJson.getInt("id"));
                //Log.i("MUR",String.valueOf(MainActivity.user.getId()));
                //Log.i("MUR",String.valueOf(messagesJson.getInt("to_id")));
                if(MainActivity.user.getId() == messagesJson.getInt("to_id"))
                    message.setLeft(false);
                else
                    message.setLeft(true);
                //Log.i("ITEM",message.toString());

                    MessageActivity.chatArrayAdapter.add(message);

            }
            isFinished = true;
            //MarketActivity.result.setText(messagesJson.getString("title"));
            old = result;
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method holds the status that
     * whether execution is provide or not
     * @return boolean isFinished
     * */
    public boolean isFinished()
    {
        return isFinished;
    }
}
