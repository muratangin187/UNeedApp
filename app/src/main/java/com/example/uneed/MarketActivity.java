package com.example.uneed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

/**
 * It's the basic Market for showing items, searching, sorting and filtering
 * @author fistikci_sahap
 * @version 5.0
 */
public class MarketActivity extends Activity
{
    public static final int CODE_GET_REQUEST = 1024;
    public static final int CODE_POST_REQUEST = 1025;
    public static Context mContext;
    public static ListView itemListView;
    public static ItemListViewAdapter listViewAdapter;

    public static TextView searchTextview;
    FloatingActionButton addItem;

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

        addItem = findViewById(R.id.addItem);


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

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                addItem();
            }
        });

    }

    /**
     * This method checks whether item fits the filter options or not
     * @param item
     * @return boolean whether item is what user is looking or not
     */
    public static boolean checkValid(Item item)
    {
        if(min_price <= item.getPrice() && item.getPrice() <= max_price)
        {
            if(category_id == 0)
                return true;

            if(category_id == item.getCategory_id())
                return true;
        }
        return false;
    }
    /**
     * This method starts FilterActivity class 
     * when user clicks the filter button
     * @param view
     */
    public void filterOpen(View view)
    {
        Intent i = new Intent(this, FilterActivity.class);
        startActivity(i);
        finish();
    }
    
    /**
     * This method starts SortActivity class 
     * when user clicks the sort button
     * @param view
     */
    public void sortOpen(View view)
    {
        Intent i = new Intent(this,SortActivity.class);
        startActivity(i);
        finish();
    }

    /**
     * This method lists the items for user's option
     *  - Date
     *  - Price
     *  - Name
     */
    public static void sortList()
    {
        Log.i("SORT",String.valueOf(sort_id));
        if(sort_id == 2131296423)
        {
            Collections.sort(items,new ItemNameComparator());
        }else if(sort_id == 2131296424)
        {
            Collections.sort(items, new ItemDateComparator());
        }else if(sort_id == 2131296425)
        {
            Collections.sort(items, new ItemPriceComparator());
        }
    }

    /**
     * This method is basic search method when user starts typing in the search bar
     * @param view
     */
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
    /**
     * This method starts addItemActivity class
     */
    public void addItem()
    {
        Intent i = new Intent(this, addItemActivity.class);
        startActivity(i);
        finish();
    }
}
