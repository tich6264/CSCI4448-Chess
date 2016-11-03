package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class OutfitCloset {
    private Outfit[] outfits;
    private User owner;
    public void addOutfit(Outfit o){

    }
    public void removeOutfit(Outfit o){

    }
    public OutfitIterator iterator(){
        return new OutfitIterator(outfits);
    }
}
