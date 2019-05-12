package com.example.uneed;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uneed.structures.GlobalData;

public class HomePage extends AppCompatActivity
{
    boolean exit = false;
    static int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        if(counter == 0)
        {
            ((GlobalData)this.getApplication()).setVariable(MainActivity.user.getId());
            counter = 1;
        }
        ((TextView) findViewById(R.id.textView2)).setText("Welcome, " + MainActivity.user.getUsername());
    }


    @Override
    public void onBackPressed()
    {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }

    public void wishlist(View view)
    {

    }

    public void openMarket(View view)
    {
        Intent i = new Intent(this, MarketActivity.class);
        startActivity(i);
    }

    public void openMessageBox(View view)
    {
        Intent i = new Intent(this, MessageBox.class);
        startActivity(i);
    }

    public void logout(View view)
    {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}
