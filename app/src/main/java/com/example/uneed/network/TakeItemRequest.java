package com.example.uneed.network;

import java.util.HashMap;

/**
 * This class send request to the server
 * to take items...
 * @author  fistikci_sahap
 * @version 1.0
 * */
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
