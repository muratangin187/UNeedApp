package com.example.uneed.network;

import android.content.Intent;

import com.example.uneed.HomePage;
import com.example.uneed.MainActivity;
import com.example.uneed.structures.User;

import org.json.JSONException;

import java.util.HashMap;

import static com.example.uneed.MainActivity.mContext;

public class LoginRequest extends PerformNetworkRequest
{


    public LoginRequest(String url, HashMap<String, String> params, int requestCode)
    {
        super(url, params, requestCode);
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        MainActivity.resultText.setText("Please wait...");
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        try
        {
            if(result.getBoolean("error") == false)
            {
                MainActivity.user = new User(result.getInt("userid"),result.getString("username"),result.getString("email"),result.getString("password"));
                Intent i = new Intent(mContext, HomePage.class);
                mContext.startActivity(i);
            }else
            {
                MainActivity.resultText.setText(result.getString("message"));
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
