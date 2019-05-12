package com.example.uneed.network;

import android.util.Log;

import com.example.uneed.Api;
import com.example.uneed.MainActivity;
import com.example.uneed.MessageActivity;
import com.example.uneed.MessageBox;
import com.example.uneed.structures.ChatMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.uneed.MainActivity.CODE_POST_REQUEST;

public class CheckMessageBoxRequest extends PerformNetworkRequest
{
    boolean isFinished = false;
    public CheckMessageBoxRequest(String url, HashMap<String, String> params, int requestCode)
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
            Log.i("DENEME",s);
            ArrayList<Integer> added = new ArrayList<Integer>();
            for(int i = 0; i < result.length()-1; i++)
            {
                messagesJson = result.getJSONObject(String.valueOf(i));
                int tempFrom = messagesJson.getInt("from_id");
                int tempTo = messagesJson.getInt("to_id");
                if(!added.contains(tempFrom) && !added.contains(tempTo))
                    added.add(messagesJson.getInt("to_id"));
            }
            isFinished = true;
            for(int item : added)
            {
                PerformNetworkRequest request;
                //Calling the create user API
                HashMap<String, String> params = new HashMap<>();
                params.put("id", String.valueOf(item));
                request = new GetNameRequest(Api.URL_GET_NAME, params, CODE_POST_REQUEST);
                request.execute();
            }
            //MessageBox.listAdapter.add(messagesJson.getString("from_id"));
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
