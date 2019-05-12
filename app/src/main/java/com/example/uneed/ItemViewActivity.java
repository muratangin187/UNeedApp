package com.example.uneed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uneed.network.GetNameRequest;
import com.example.uneed.network.GetSellerNameRequest;
import com.example.uneed.network.PerformNetworkRequest;
import com.example.uneed.structures.Item;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.HashMap;

import static com.example.uneed.MarketActivity.CODE_POST_REQUEST;

/**
 * When user clicks an item on the marketplace
 * this class starts running and shows the information of an item
 * @author fistikci_sahap
 * @version 3.0
 */
public class ItemViewActivity extends AppCompatActivity
{

    ImageView itemImageView;
    static public TextView itemTitleView;
    static public TextView itemSellerView;
    static public TextView itemPriceView;
    static public TextView itemDateView;
    static public TextView itemDescriptionView;
    ImageButton chatButton;

    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        int itemId = getIntent().getIntExtra("ITEM_ID",0);
        //Log.i("Item id " ,itemId+"");
        item = MarketActivity.items.get(itemId-1);
        //Log.i("Item ", item.toString());
        itemImageView = findViewById(R.id.itemImageView);
        itemTitleView = findViewById(R.id.itemTitleView);
        itemSellerView = findViewById(R.id.itemSellerView);
        itemPriceView = findViewById(R.id.itemPriceView);
        itemDateView = findViewById(R.id.itemDateView);
        itemDescriptionView = findViewById(R.id.itemDescriptionView);
//        wishlistButton = findViewById(R.id.wishlistButton);
        chatButton = findViewById(R.id.chatButton);
        settings();
    }

    /**
     * This method initiates MessageActivity class
     * when user clicks 'make contact' button
     * @param view
     */
    public void createChat(View view)
    {
        Intent i = new Intent(this, MessageActivity.class);
        i.putExtra("to_id", Integer.valueOf(item.getSeller_id()));
        startActivity(i);
    }

    /**
     * This method pulls the information from database 
     * and show it to the description part
     */
    private void settings()
    {
        Picasso.get().load(item.getPhoto()).into(itemImageView);
        itemTitleView.setText("Title\n" + item.getTitle());
        PerformNetworkRequest request;
        //Calling the create user API
        HashMap<String, String> params = new HashMap<>();
        params.put("id", item.getSeller_id() + "");
        request = new GetSellerNameRequest(Api.URL_GET_NAME, params, CODE_POST_REQUEST);
        request.execute();

        itemSellerView.setText("Seller\n" + String.valueOf(item.getSeller_id()));
        itemPriceView.setText("Price\n" + String.valueOf(item.getPrice()));
        itemDateView.setText("Date\n" + item.getDate());
        itemDescriptionView.setText("Description\n" + item.getDescription());
    }
}
