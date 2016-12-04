package com.closetbot.model;

import org.hibernate.internal.util.SerializationHelper;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Owner on 11/2/2016.
 */
@Entity
public class OutfitCloset implements Serializable {
    private           ArrayList<Outfit> outfits;

    public OutfitCloset() {
        outfits = new ArrayList<>();
    }

    public void addOutfit(Outfit o) {

    }

    public void removeOutfit(Outfit o) {

    }

    public OutfitIterator iterator() {
        return new OutfitIterator(outfits.toArray(new Outfit[outfits.size()]));
    }


    @Lob
    public <T> T getData() {
        return (T) SerializationHelper.serialize(this);
    }
}
