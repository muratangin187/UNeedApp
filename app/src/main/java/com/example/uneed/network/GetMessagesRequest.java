package com.example.uneed.network;

import android.util.Log;

import com.example.uneed.MainActivity;
import com.example.uneed.MessageActivity;
import com.example.uneed.structures.ChatArrayAdapter;
import com.example.uneed.structures.ChatMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class GetMessagesRequest extends PerformNetworkRequest
{
    boolean isFinished = false;
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
            //Log.i("DENEME",result.toString());
            MessageActivity.chatArrayAdapter.clear();
            for(int i = 0; i < result.length()-1; i++)
            {
                messagesJson = result.getJSONObject(String.valueOf(i));
                //Log.i("BAK", messagesJson.toString());
                ChatMessage message = new ChatMessage(messagesJson.getString("message"),messagesJson.getString("date"),messagesJson.getInt("from_id"),messagesJson.getInt("to_id"));
                message.setId(messagesJson.getInt("id"));
                //Log.i("AQ",String.valueOf(MainActivity.user.getId()));
                //Log.i("AQ",String.valueOf(messagesJson.getInt("to_id")));
                if(MainActivity.user.getId() == messagesJson.getInt("to_id"))
                    message.setLeft(false);
                else
                    message.setLeft(true);
                //Log.i("ITEM",message.toString());

                    MessageActivity.chatArrayAdapter.add(message);

            }
            isFinished = true;
            //MarketActivity.result.setText(messagesJson.getString("title"));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
    public boolean isFinished()
    {
        return isFinished;
    }
}
