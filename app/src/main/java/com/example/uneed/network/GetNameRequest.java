package com.example.uneed.network;

import android.util.Log;

import com.example.uneed.MainActivity;
import com.example.uneed.MessageActivity;
import com.example.uneed.MessageBox;
import com.example.uneed.structures.ChatMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class GetNameRequest extends PerformNetworkRequest
{
    boolean isFinished = false;
    public GetNameRequest(String url, HashMap<String, String> params, int requestCode)
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
            Log.i("DENEME",result.getString("username"));
            MessageBox.listAdapter.add(params.get("id") + " - " + result.getString("username"));
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
