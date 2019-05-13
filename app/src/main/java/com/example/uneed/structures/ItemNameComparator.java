package com.example.uneed.structures;

import java.util.Comparator;
/**
 * Compare class for items by using their names
 * @author fistikci_sahap
 * @version 1.0
 */
public class ItemNameComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
