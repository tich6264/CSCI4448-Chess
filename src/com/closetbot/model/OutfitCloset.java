package com.closetbot.model;

import org.hibernate.internal.util.SerializationHelper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;

/**
 * Created by Owner on 11/2/2016.
 */
@Entity
public class OutfitCloset implements Serializable{
    private Outfit[] outfits;
    private transient User owner;
    public void addOutfit(Outfit o){

    }
    public void removeOutfit(Outfit o){

    }
    public OutfitIterator iterator(){
        return new OutfitIterator(outfits);
    }


    @Lob
    public <T> T getData(){
        return (T) SerializationHelper.serialize(this);
    }

}
