package com.example.uneed.structures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uneed.Api;
import com.example.uneed.R;
import com.example.uneed.network.LoginRequest;
import com.example.uneed.network.PerformNetworkRequest;

import java.util.HashMap;

/**
 * This class checks whether user enters the correct information or not
 * @author fistikci_sahap
 * @version 1.0 
 */
public class LoginActivity extends AppCompatActivity {

    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;

    public static EditText usernameText;
    public static EditText passwordText;
    public static TextView resultText;

    PerformNetworkRequest request;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = findViewById(R.id.login_username);
        passwordText = findViewById(R.id.login_pass);
        resultText = findViewById(R.id.result_text);
    }

    public void userLogin(View view)
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
}
