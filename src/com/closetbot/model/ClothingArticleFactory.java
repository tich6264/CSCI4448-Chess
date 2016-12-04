package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class ClothingArticleFactory {
    public ClothingArticle createClothingArticle(Type type, Color c, Pattern p, Season s) {
        if (type instanceof BottomTypes) {
            return new Bottom(c, p, s, (BottomTypes) type);
        } else if (type instanceof ShoeTypes) {
            return new Shoes(c, p, s, (ShoeTypes) type);
        } else if (type instanceof TopTypes) {
            return new Top(c, p, s, (TopTypes) type);
        } else if (type instanceof AccessoryTypes) {
            return new Accessories(c, p, s, (AccessoryTypes) type);
        }
        return null;
    }

    public ClothingArticle updateClothingArticle(Type type, Color c, Pattern p, Season s) {
        return null;
    }
}
