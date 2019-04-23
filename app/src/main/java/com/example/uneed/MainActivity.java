package com.example.uneed;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uneed.network.LoginRequest;
import com.example.uneed.network.PerformNetworkRequest;
import com.example.uneed.network.RegisterRequest;
import com.example.uneed.structures.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;

    public static JSONObject object;
    public static User user;
    public static boolean checkLogin;
    public static TextView resultText;
    public static EditText usernameText;
    public static EditText passwordText;
    public static EditText emailText;
    public static TabLayout tabLayout;
    public static Context mContext;

    PerformNetworkRequest request;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         mContext = this;
        resultText = findViewById(R.id.textView);
        usernameText = findViewById(R.id.editText);
        passwordText = findViewById(R.id.editText2);
        emailText = findViewById(R.id.editText3);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                Log.i("TAG", "onTabSelected: " + tab.getText());
                if(tab.getPosition() == 0)
                {
                    emailText.setVisibility(View.GONE);
                    findViewById(R.id.button2).setVisibility(GONE);
                    findViewById(R.id.button).setVisibility(View.VISIBLE);
                    resultText.setText("");
                }else
                {
                    emailText.setVisibility(View.VISIBLE);
                    findViewById(R.id.button2).setVisibility(View.VISIBLE);
                    findViewById(R.id.button).setVisibility(GONE);
                    resultText.setText("");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });
    }

    public void login(View view)
    {
        String username = usernameText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        //validating the inputs
        if (TextUtils.isEmpty(username)) {
            usernameText.setError("Please enter name");
            usernameText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordText.setError("Please enter password");
            passwordText.requestFocus();
            return;
        }

        //if validation passes

        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);


        //Calling the create user API
        request = new LoginRequest(Api.URL_LOGIN, params, CODE_POST_REQUEST);
        request.execute();
    }

    public void register(View view) {
        String username = usernameText.getText().toString().trim();
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        //validating the inputs
        if (TextUtils.isEmpty(username)) {
            usernameText.setError("Please enter name");
            usernameText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            emailText.setError("Please enter email");
            emailText.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordText.setError("Please enter password");
            passwordText.requestFocus();
            return;
        }

        //if validation passes

        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("email", email);
        params.put("password", password);
        request = new RegisterRequest(Api.URL_CREATE_USER, params, CODE_POST_REQUEST);
        request.execute();

    }
}

