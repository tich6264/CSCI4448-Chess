package com.closetbot.model;

/**
 * Created by Owner on 11/2/2016.
 */
public class ClothingArticleFactory {
    public ClothingArticle createClothingArticle(Type type){
        if(type instanceof BottomTypes){
            return new Bottom((BottomTypes) type);
        }
        else if(type instanceof ShoeTypes){
            return new Shoes((ShoeTypes) type);
        }
        else if(type instanceof TopTypes){
            return new Top((TopTypes) type);
        }
        else if(type instanceof AccessoryTypes){
            return new Accessories((AccessoryTypes) type);
        }
        return null;
    }
}
