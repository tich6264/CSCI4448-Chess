package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class Accessories extends ClothingArticle {
    public AccessoryTypes type;

    public Accessories(AccessoryTypes _type){
        type = _type;
    }

    public Accessories(AccessoryTypes _type, DecoratorWrapper _article){
        type = _type;
        article = _article;
    }
}

