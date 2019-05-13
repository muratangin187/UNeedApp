package com.example.uneed.network;

import android.content.Intent;

import com.example.uneed.HomePage;
import com.example.uneed.MainActivity;
import com.example.uneed.structures.SignUpActivity;
import com.example.uneed.structures.User;

import org.json.JSONException;

import java.util.HashMap;

import static com.example.uneed.MainActivity.mContext;

/**
 * This class send request to the server
 * for RegisterActivity
 * @author  fistikci_sahap
 * @version 1.0
 * */
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
//        SignUpActivity.resultText.setText("New user is creating...");
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        try
        {
//            SignUpActivity.resultText.setText("Eroooodofoofd");
            SignUpActivity.userExists = true;
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
