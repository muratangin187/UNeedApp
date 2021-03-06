package com.example.uneed.network;

import android.util.Log;

import com.example.uneed.ItemViewActivity;
import com.example.uneed.MessageBox;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * This class send request to the server
 * in order to get seller names from the database
 * @author  fistikci_sahap
 * @version 1.0
 * */
public class GetSellerNameRequest extends PerformNetworkRequest
{
    boolean isFinished = false;
    public GetSellerNameRequest(String url, HashMap<String, String> params, int requestCode)
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
            ItemViewActivity.itemSellerView.setText(result.getString("username"));
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
