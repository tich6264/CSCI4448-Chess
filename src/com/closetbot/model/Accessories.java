package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class Accessories extends ClothingArticle {
    public AccessoryTypes type;

    public Accessories(Color c, Pattern p, Season s, AccessoryTypes _type, DecoratorWrapper _article){
        super(c,p,s);
        type = _type;
        article = _article;
    }
    public Accessories(Color c, Pattern p, Season s, AccessoryTypes _type){
        super(c,p,s);
        type = _type;
    }

    @Override
    public void setType(Type type) {
        this.type = (AccessoryTypes) type;
    }

    @Override
    public Type getType() {
        return type;
    }
}

