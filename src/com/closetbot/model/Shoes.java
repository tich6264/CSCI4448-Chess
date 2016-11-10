package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class Shoes extends ClothingArticle {
    public ShoeTypes type;

    public Shoes(ShoeTypes _type){
        type = _type;
    }

    public Shoes( ShoeTypes _type, DecoratorWrapper _article ){
        type = _type;
        article = _article;
    }
}
