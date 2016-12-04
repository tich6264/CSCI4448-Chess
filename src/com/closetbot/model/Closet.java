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
    private static final long serialVersionUID = 5440266021897153962L;

    public Closet(){
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
        return clothes.toArray(new ClothingArticle[clothes.size()]);
    }

    public ClothingArticle findClothingArticle(ClothingArticle _clothes) {
        for (ClothingArticle cl: clothes) {
            if(_clothes == cl)
                return cl;
        }
        return null;
    }

    @Lob
    public <T> T getData(){
        return (T) SerializationHelper.serialize(this);
    }
}
