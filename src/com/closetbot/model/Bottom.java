package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class Bottom extends ClothingArticle {
    public BottomTypes type;

    public Bottom(BottomTypes _type){
        type = _type;
    }

    public Bottom( BottomTypes _type, DecoratorWrapper _article ){
        type = _type;
        article = _article;
    }
}