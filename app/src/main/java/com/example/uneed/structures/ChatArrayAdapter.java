package com.example.uneed.structures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.uneed.R;

import java.util.ArrayList;
import java.util.List;

/**
 * This class shows the previous messages between users
 * @author fistikci_sahap
 * @version 3.0
 */
public class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {

    private TextView chatText;
    private TextView chatDate;
    public List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();
    private Context context;
    public static int maxId; // last message id
    @Override
    public void add(ChatMessage object) {
        chatMessageList.add(object);
        if(maxId < object.id)
            maxId = object.id;
        super.add(object);
    }

    /**
     * Cleans the messages when user exits the chat room
     */
    public void clear()
    {
        chatMessageList.clear();
    }

    /**
     * 
     * @return static int ID of the last message
     */
    public static int getMaxId()
    {
        return maxId;
    }
    /**
     * This method adds every message for only one time
     * @param id
     * @return boolean whether the message added to the array or not
     */
    public boolean contains(int id)
    {

        for(int i = 0; i < chatMessageList.size(); i++)
        {
            if(chatMessageList.get(i).id == id)
                return true;
        }
        return false;
    }
    
    public ChatArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
    }

    public int getCount() {
        return this.chatMessageList.size();
    }

    public ChatMessage getItem(int index) {
        return this.chatMessageList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage chatMessageObj = getItem(position);
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (chatMessageObj.left) {
            row = inflater.inflate(R.layout.right, parent, false);
        }else{
            row = inflater.inflate(R.layout.left, parent, false);
        }
        chatText = (TextView) row.findViewById(R.id.msgr);
        chatText.setText(chatMessageObj.message);
        chatDate = row.findViewById(R.id.date_msgr);
        String result = chatMessageObj.date.substring(11,16);
        chatDate.setText(result);
        return row;
    }
}