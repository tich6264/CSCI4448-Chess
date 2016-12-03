package com.closetbot.model;

import org.hibernate.internal.util.SerializationHelper;

import javax.persistence.Lob;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Owner on 11/2/2016.
 */

public class Closet implements Serializable{
    private ArrayList<ClothingArticle> clothes;
    private transient User owner;

    public Closet( User _owner ){
        owner = _owner;
        clothes = new ArrayList<>();
    }

    public void addClothingArticle( ClothingArticle clothingArticle ){
        clothes.add( clothingArticle );
    }

    public void removeClothingArticle( ClothingArticle clothingArticle ){
        clothes.remove( clothingArticle );
    }

    public Outfit[] generateOutfits( Season s ){
        return null;
    }

    public ClothingArticle[] getClothes(){
        return (ClothingArticle[])clothes.toArray();
    }

    @Lob
    public <T> T getData(){
        return (T) SerializationHelper.serialize(this);
    }
}
