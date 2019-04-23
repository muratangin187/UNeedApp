package com.example.uneed;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.uneed.network.ListItemRequest;
import com.example.uneed.network.PerformNetworkRequest;
import com.example.uneed.structures.Item;
import com.example.uneed.structures.ItemListViewAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MarketActivity extends Activity
{
    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;
    public static Context mContext;
    public static ListView itemListView;
    public static ItemListViewAdapter listViewAdapter;
    PerformNetworkRequest request;
    public static ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE); // for hiding title

       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
         //       WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_market);
        items = new ArrayList<Item>();
        itemListView = findViewById(R.id.itemListView);
        listViewAdapter = new ItemListViewAdapter(this,items);
        itemListView.setAdapter(listViewAdapter);
        mContext = this;
        request = (PerformNetworkRequest)(new ListItemRequest(Api.URL_LIST_ITEMS,new HashMap<String, String>(),CODE_GET_REQUEST)).execute();

    }

}
