package com.closetbot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/2/2016.
 */
public abstract class ClothingArticle implements DecoratorWrapper {
    private Color color;
    private Pattern pattern;
    private Season season;
    private Type type;

    protected DecoratorWrapper article = null;

    @Override
    public List getClothingArticle() {
        List toRet = null;
        if( article != null ){
            toRet = article.getClothingArticle();
        }
        if( toRet == null ){
            toRet = new ArrayList<DecoratorWrapper>();
        }
        toRet.add(this);
        return toRet;
    }
    public Color getColor(){
        return color;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Season getSeason() {
        return season;
    }

    public Type getType() {
        return type;
    }
}