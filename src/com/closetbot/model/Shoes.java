package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class Shoes extends ClothingArticle {
    public ShoeTypes type;

    public Shoes(Color c, Pattern p, Season s, ShoeTypes _type, DecoratorWrapper _article){
        super(c,p,s);
        type = _type;
        article = _article;
    }
    public Shoes(Color c, Pattern p, Season s, ShoeTypes _type){
        super(c,p,s);
        type = _type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
