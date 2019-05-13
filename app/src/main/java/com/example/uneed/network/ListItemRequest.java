package com.example.uneed.network;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uneed.MainActivity;
import com.example.uneed.MarketActivity;
import com.example.uneed.R;
import com.example.uneed.structures.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * This class send request to the server
 * in order to take items from database
 * @author  fistikci_sahap
 * @version 1.0
 * */
public class ListItemRequest extends PerformNetworkRequest
{
    boolean isFinished = false;
    public ListItemRequest(String url, HashMap<String, String> params, int requestCode)
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
        JSONObject itemJson = null;
        try
        {
            //Log.i("DENEME",result.toString());
            for(int i = 0; i < result.length()-1; i++)
            {
                itemJson = result.getJSONObject(String.valueOf(i));
                //Log.i("BAK", itemJson.getString("title"));
                Item item = new Item(itemJson.getInt("item_id"),itemJson.getInt("seller_id"),itemJson.getString("title"),itemJson.getString("photo"),itemJson.getInt("price"),itemJson.getString("description"),itemJson.getInt("category_id"),itemJson.getString("item_date"));
                if(MarketActivity.checkValid(item))
                    MarketActivity.items.add(item);
            }
            MarketActivity.sortList();
            MarketActivity.listViewAdapter.notifyDataSetChanged();
            isFinished = true;
            //MarketActivity.result.setText(itemJson.getString("title"));
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
