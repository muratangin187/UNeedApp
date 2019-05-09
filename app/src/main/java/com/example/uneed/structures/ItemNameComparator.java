package com.example.uneed.structures;

import java.util.Comparator;

public class ItemNameComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
