package com.example.uneed.structures;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class ItemDateComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        DateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return f.parse(o2.getDate()).compareTo(f.parse(o1.getDate()));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
