package com.closetbot.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/2/2016.
 */
public class Outfit implements DecoratorWrapper {
    private DecoratorWrapper article = null;

    public Outfit( DecoratorWrapper _article ){
        article = _article;
    }

    @Override
    public List getClothingArticle(){
        List toRet = null;
        if( article != null ){
            toRet = article.getClothingArticle();
        }
        if( toRet == null ){
            toRet = new ArrayList<DecoratorWrapper>();
        }
        return toRet;
    }
}
