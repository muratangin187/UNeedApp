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
import com.example.uneed.structures.LoginActivity;
import com.example.uneed.structures.SignUpActivity;
import com.example.uneed.structures.User;

import org.json.JSONObject;

import java.util.HashMap;

import static android.view.View.GONE;

/**
 * This class creates the enter page for user
 * @author fistikci_sahap
 * @version 6.0
 */
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
        setContentView(R.layout.activity_main1);
         mContext = this;
        resultText = findViewById(R.id.textView);
        usernameText = findViewById(R.id.login_username);
        passwordText = findViewById(R.id.login_pass);
        emailText = findViewById(R.id.sign_up_email);
        tabLayout = findViewById(R.id.tabLayout);
    }

    /**
     * When user clicks login page, 
     * this method executes LoginActivity class and stops this class
     * @param view
     */
    public void openLogin(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
    
    /**
     * When user clicks register page, 
     * this method executes SignUpActivity class and stops this class
     * @param view
     */
    public void openSingUp(View view){
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
        finish();
    }
}

