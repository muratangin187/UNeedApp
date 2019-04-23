package com.example.uneed.network;

import java.util.HashMap;

public class TakeItemRequest extends PerformNetworkRequest
{
    public TakeItemRequest(String url, HashMap<String, String> params, int requestCode)
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
    }
}
