package com.example.uneed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SortActivity extends AppCompatActivity {

    RadioGroup radioSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        radioSort = (RadioGroup)findViewById(R.id.radioSort);
    }

    public void closeSort(View view)
    {
        Intent i = new Intent(this, MarketActivity.class);
        i.putExtra("sort_id", radioSort.getCheckedRadioButtonId());
        startActivity(i);
        finish();
    }

}
