package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class Bottom extends ClothingArticle {
    public BottomTypes type;
    private static final long serialVersionUID = 2882654077324007734L;

    public Bottom(Color c, Pattern p, Season s, BottomTypes _type, DecoratorWrapper _article){
        super(c,p,s);
        type = _type;
        article = _article;
    }
    public Bottom(Color c, Pattern p, Season s, BottomTypes _type){
        super(c,p,s);
        type = _type;
    }

    @Override
    public void setType(Type type) {
        this.type = (BottomTypes) type;
    }

    @Override
    public Type getType() {
        return type;
    }
}