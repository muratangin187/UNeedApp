package com.example.uneed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class addItemActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void closeAddItem(View view)
    {
        Intent i = new Intent(this, MarketActivity.class);
//        i.putExtra("sort_id", radioSort.getCheckedRadioButtonId());
        startActivity(i);
        finish();
    }
}
