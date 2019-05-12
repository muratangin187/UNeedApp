package com.example.uneed.network;

import android.content.Intent;
import android.util.Log;

import com.example.uneed.HomePage;
import com.example.uneed.MainActivity;
import com.example.uneed.structures.ChatArrayAdapter;
import com.example.uneed.structures.User;

import org.json.JSONException;

import java.util.HashMap;

import static com.example.uneed.MainActivity.mContext;

public class SendMessageRequest extends PerformNetworkRequest
{

    public SendMessageRequest(String url, HashMap<String, String> params, int requestCode)
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
        Log.i("SON", s);
    }
}
