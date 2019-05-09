package com.example.uneed.structures;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return ((Double)o1.getPrice()).compareTo(o2.getPrice());
    }
}
