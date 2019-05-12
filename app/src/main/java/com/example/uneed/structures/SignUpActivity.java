package com.example.uneed.structures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uneed.Api;
import com.example.uneed.R;
import com.example.uneed.network.PerformNetworkRequest;
import com.example.uneed.network.RegisterRequest;

import java.util.HashMap;

/**
 * This class compares the user entries with database
 * @author fistikci_sahap
 * @version 1.0
 */
public class SignUpActivity extends AppCompatActivity {

    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;


    public static EditText usernameText;
    public static EditText emailText;
    public static EditText passwordText;
    public static EditText confirmPass;
    public static TextView resultText;
    public static boolean userExists;

    PerformNetworkRequest request;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameText = findViewById(R.id.sign_up_username);
        emailText = findViewById(R.id.sign_up_email);
        passwordText = findViewById(R.id.sign_up_pass);
        confirmPass = findViewById(R.id.sign_up_confirm_pass);
        resultText = findViewById(R.id.sign_up_result);
        userExists = false;
    }

    public void signUp(View view) {
        String username = usernameText.getText().toString().trim();
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        String confirmPassword = confirmPass.getText().toString().trim();

        //validating the inputs
        if (TextUtils.isEmpty(username)) {
            usernameText.setError("Please enter name");
            usernameText.requestFocus();
            return;
        }else {
            if(userExists){
                usernameText.setError("Username already taken");
                usernameText.requestFocus();
                return;
            }
        }

        if (TextUtils.isEmpty(email)) {
            emailText.setError("Please enter email");
            emailText.requestFocus();
            return;
        }else {
            if(!email.contains("@ug.bilkent.edu.tr")){
                emailText.setError("Please enter a University email");
                emailText.requestFocus();
                return;
            }
        }

        if (TextUtils.isEmpty(password)) {
            passwordText.setError("Please enter password");
            passwordText.requestFocus();
            return;
        }else {
            if(!password.equals(confirmPassword)){
                confirmPass.setError("Passwords do not match");
                confirmPass.requestFocus();
                return;
            }
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
