package com.example.uneed.structures;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
/**
 * Compare class for items by using their adding date
 * @author fistikci_sahap
 * @version 1.0
 */
public class ItemDateComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        if(o1.getId() > o2.getId())
        {
            return 1;
        }else if(o1.getId() < o2.getId())
        {
            return -1;
        }else
        {
            return 0;
        }

    }
}
