package com.example.uneed.structures;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uneed.ItemViewActivity;
import com.example.uneed.MarketActivity;
import com.example.uneed.R;
import com.example.uneed.network.DownloadImageTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemListViewAdapter extends ArrayAdapter<Item>
{
    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private final ArrayList<Item> items;
    public ItemListViewAdapter(Context context, ArrayList<Item> items)
    {
        super(context, 0, items);
        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.list_view_item, null);

            holder = new ViewHolder();
            holder.itemImage = convertView.findViewById(R.id.itemPhotoView);
            holder.titleView = convertView.findViewById(R.id.titleView);
            holder.priceView = convertView.findViewById(R.id.priceView);
            holder.dateView = convertView.findViewById(R.id.dateView);
            holder.itemLayout = convertView.findViewById(R.id.itemLayout);
            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder) convertView.getTag();
        }

        final Item item = items.get(position);
        if(item != null){
            //new DownloadImageTask(holder.itemImage).execute(String.valueOf(item.getPhoto()));
            Picasso.get().load(item.getPhoto()).into(holder.itemImage);
            holder.titleView.setText(item.getTitle());
            holder.priceView.setText(String.valueOf(item.getPrice()));
            holder.dateView.setText(item.getDate());
            holder.itemLayout.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    itemLayoutButton(item.getId());
                }
            });
        }
        return convertView;
    }

    private void itemLayoutButton(int id)
    {
        Intent intent = new Intent(MarketActivity.mContext, ItemViewActivity.class);
        intent.putExtra("ITEM_ID",id);
        MarketActivity.mContext.startActivity(intent);
    }


    private static class ViewHolder {
        TextView titleView;
        TextView priceView;
        TextView dateView;
        ImageView itemImage;
        LinearLayout itemLayout;
    }
}
