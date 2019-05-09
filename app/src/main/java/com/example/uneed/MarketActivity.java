package com.example.uneed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.example.uneed.structures.ItemDateComparator;
import com.example.uneed.structures.ItemListViewAdapter;
import com.example.uneed.structures.ItemNameComparator;
import com.example.uneed.structures.ItemPriceComparator;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MarketActivity extends Activity
{
    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;
    public static Context mContext;
    public static ListView itemListView;
    public static ItemListViewAdapter listViewAdapter;

    public static TextView searchTextview;

    public static int category_id;
    public static int min_price = 0;
    public static int max_price = 500;
    public static int sort_id = 0;


    PerformNetworkRequest request;
    public static ArrayList<Item> items;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        items = new ArrayList<Item>();
        itemListView = findViewById(R.id.itemListView);
        listViewAdapter = new ItemListViewAdapter(this,items);
        itemListView.setAdapter(listViewAdapter);
        mContext = this;
        searchTextview = (TextView)findViewById(R.id.searchText);

        request = (PerformNetworkRequest)(new ListItemRequest(Api.URL_LIST_ITEMS,new HashMap<String, String>(),CODE_GET_REQUEST)).execute();

        Intent intent = getIntent();
        if(intent.hasExtra("category_id")) {
            //Log.i("AMK",intent.getExtras().toString());
            category_id = intent.getExtras().getInt("category_id");
            min_price = (int)intent.getExtras().getLong("min_price");
            max_price = (int)intent.getExtras().getLong("max_price");
            //Log.i("PRICE", String.valueOf(min_price));
        }
        if(intent.hasExtra("sort_id")) {
            //Log.i("AMK",intent.getExtras().toString());
            sort_id = intent.getExtras().getInt("sort_id");
            //Log.i("PRICE", String.valueOf(min_price));
        }
    }

    public static boolean checkValid(Item item)
    {
        //Log.i("AMK",String.valueOf(item.getPrice()));
        //Log.i("AMK",String.valueOf(min_price));
        //Log.i("AMK",String.valueOf(max_price));
        if(min_price <= item.getPrice() && item.getPrice() <= max_price)
        {

            if(category_id == 0)
                return true;

            if(category_id == item.getCategory_id())
                return true;

        }
        return false;
    }

    public void filterOpen(View view)
    {
        Intent i = new Intent(this, FilterActivity.class);
        startActivity(i);
        finish();
    }

    public void sortOpen(View view)
    {
        Intent i = new Intent(this,SortActivity.class);
        startActivity(i);
        finish();
    }

    public static void sortList()
    {
        if(sort_id == 2131296409)
        {
            Collections.sort(items,new ItemNameComparator());
        }else if(sort_id == 2131296410)
        {
            Collections.sort(items, new ItemDateComparator());
        }else if(sort_id == 2131296411)
        {
            Collections.sort(items, new ItemPriceComparator());
        }
    }

    public void searchButton(View view)
    {
        ArrayList<Item> searchedItems = new ArrayList<Item>();
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getTitle().contains(searchTextview.getText())) {
                searchedItems.add(items.get(i));
            }
        }
        ItemListViewAdapter newListViewAdapter = new ItemListViewAdapter(this,searchedItems);

        itemListView.setAdapter(newListViewAdapter);
        newListViewAdapter.notifyDataSetChanged();
    }
}
