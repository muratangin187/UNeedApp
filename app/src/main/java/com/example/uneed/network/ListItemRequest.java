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

public class ListItemRequest extends PerformNetworkRequest
{
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
            Log.i("DENEME",result.toString());
            for(int i = 0; i < result.length()-1; i++)
            {
                itemJson = result.getJSONObject(String.valueOf(i));
                Log.i("BAK", itemJson.getString("title"));
                Item item = new Item(itemJson.getInt("item_id"),itemJson.getInt("seller_id"),itemJson.getString("title"),itemJson.getString("photo"),itemJson.getInt("price"),itemJson.getString("description"),itemJson.getInt("category_id"),itemJson.getString("item_date"));
                MarketActivity.items.add(item);
            }
            MarketActivity.listViewAdapter.notifyDataSetChanged();
            //MarketActivity.result.setText(itemJson.getString("title"));
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
