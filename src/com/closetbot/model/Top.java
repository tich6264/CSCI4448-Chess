package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class Top extends ClothingArticle {
    public TopTypes type;

    public Top(Color c, Pattern p, Season s, TopTypes _type, DecoratorWrapper _article){
        super(c,p,s);
        type = _type;
        article = _article;
    }
    public Top(Color c, Pattern p, Season s, TopTypes _type){
        super(c,p,s);
        type = _type;
    }
}
