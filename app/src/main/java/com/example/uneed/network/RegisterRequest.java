package com.example.uneed.network;

import android.content.Intent;

import com.example.uneed.HomePage;
import com.example.uneed.MainActivity;
import com.example.uneed.structures.User;

import org.json.JSONException;

import java.util.HashMap;

import static com.example.uneed.MainActivity.mContext;

public class RegisterRequest extends PerformNetworkRequest
{

    public RegisterRequest(String url, HashMap<String, String> params, int requestCode)
    {
        super(url, params, requestCode);
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        MainActivity.resultText.setText("New user is creating...");
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        try
        {
            MainActivity.resultText.setText(result.getString("message"));
            if(result.getBoolean("error") == false)
            {
                MainActivity.user = new User(result.getInt("userid"),result.getString("username"),result.getString("email"),result.getString("password"));
                Intent i = new Intent(mContext, HomePage.class);
                mContext.startActivity(i);
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}
