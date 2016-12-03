package com.closetbot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Owner on 11/2/2016.
 */
public class OutfitIterator implements Iterator
{
    private Outfit[] stuff;
    private int      index;
    private int      size;
    public OutfitIterator(Outfit[] outfits){
        stuff = outfits;
        index = 0;
        size = outfits.length;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Object next() {
        return stuff[index++];
    }
}
