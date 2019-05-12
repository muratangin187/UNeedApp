package com.example.uneed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uneed.structures.Item;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ItemViewActivity extends AppCompatActivity
{

    ImageView itemImageView;
    TextView itemTitleView;
    TextView itemSellerView;
    TextView itemPriceView;
    TextView itemDateView;
    TextView itemDescriptionView;
    Button wishlistButton;
    ImageButton chatButton;

    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);
        int itemId = getIntent().getIntExtra("ITEM_ID",0);
        item = MarketActivity.items.get(itemId-1);
        itemImageView = findViewById(R.id.itemImageView);
        itemTitleView = findViewById(R.id.add_item_title);
        itemSellerView = findViewById(R.id.itemSellerView);
        itemPriceView = findViewById(R.id.itemPriceView);
        itemDateView = findViewById(R.id.itemDateView);
        itemDescriptionView = findViewById(R.id.itemDescriptionView);
//        wishlistButton = findViewById(R.id.wishlistButton);
        chatButton = findViewById(R.id.chatButton);
        settings();
    }

    private void settings()
    {
        Picasso.get().load(item.getPhoto()).into(itemImageView);
        itemTitleView.setText("Title\n" + item.getTitle());
        itemSellerView.setText("Seller\n" + String.valueOf(item.getSeller_id()));
        itemPriceView.setText("Price\n" + String.valueOf(item.getPrice()));
        itemDateView.setText("Date\n" + item.getDate());
        itemDescriptionView.setText("Description\n" + item.getDescription());
    }
}
