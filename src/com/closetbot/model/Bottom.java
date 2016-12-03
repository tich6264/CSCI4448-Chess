package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class Bottom extends ClothingArticle {
    public BottomTypes type;

    public Bottom(Color c, Pattern p, Season s, BottomTypes _type, DecoratorWrapper _article){
        super(c,p,s);
        type = _type;
        article = _article;
    }
    public Bottom(Color c, Pattern p, Season s, BottomTypes _type){
        super(c,p,s);
        type = _type;
    }
}