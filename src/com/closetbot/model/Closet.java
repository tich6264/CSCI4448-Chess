package com.closetbot.model;

import java.util.ArrayList;

/**
 * Created by Owner on 11/2/2016.
 */

public class Closet {
    private ArrayList<ClothingArticle> clothes;
    private User owner;

    public Closet( User _owner ){
        owner = _owner;
        clothes = new ArrayList<>();
    }

    void addClothingArticle( ClothingArticle clothingArticle ){
        clothes.add( clothingArticle );
    }

    void removeClothingArticle( ClothingArticle clothingArticle ){
        clothes.remove( clothingArticle );
    }

    Outfit[] generateOutfits( Season s ){
        return null;
    }

    ClothingArticle[] getClothes(){
        return (ClothingArticle[])clothes.toArray();
    }
}
