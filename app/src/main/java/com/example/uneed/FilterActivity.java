package com.example.uneed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

import java.util.HashMap;

/**
 * When user clicks filter button 
 * this class shows price range and category options
 * @author fistikci_sahap
 * @version 1.0
 */
public class FilterActivity extends AppCompatActivity {

    CrystalRangeSeekbar rangeSeekbar;
    TextView tvMin;
    TextView tvMax;
    Spinner category_spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        // set listener
        // get seekbar from view
        rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar1);
        // get min and max text view
        tvMin = (TextView) findViewById(R.id.textView5);
        tvMax = (TextView) findViewById(R.id.textView6);
        category_spinner = (Spinner) findViewById(R.id.spinner);
        rangeSeekbar.setMaxValue(500);
        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText(String.valueOf(minValue));
                tvMax.setText(String.valueOf(maxValue));
            }
        });

// set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });
    }


    /**
     * This methods initiates MarketActivity class and sends
     * the information that user desired (specific category or price range) 
     * @param view
     */
    public void closeFilter(View view)
    {
        Intent i = new Intent(this, MarketActivity.class);
        i.putExtra("category_id",category_spinner.getSelectedItemPosition());
        i.putExtra("min_price", rangeSeekbar.getSelectedMinValue());
        i.putExtra("max_price", rangeSeekbar.getSelectedMaxValue());
        startActivity(i);
        finish();
    }

}
