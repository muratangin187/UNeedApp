package com.example.uneed.network;

import android.content.Intent;

import com.example.uneed.HomePage;
import com.example.uneed.MainActivity;
import com.example.uneed.MarketActivity;
import com.example.uneed.structures.Item;
import com.example.uneed.structures.SignUpActivity;
import com.example.uneed.structures.User;

import org.json.JSONException;

import java.util.HashMap;

import static com.example.uneed.MainActivity.mContext;

public class AddItemRequest extends PerformNetworkRequest
{

    public AddItemRequest(String url, HashMap<String, String> params, int requestCode)
    {
        super(url, params, requestCode);
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
//        SignUpActivity.resultText.setText("New user is creating...");
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        Intent i = new Intent(mContext, MarketActivity.class);
        mContext.startActivity(i);
    }
}
