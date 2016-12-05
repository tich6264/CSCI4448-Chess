package com.closetbot.model;

import org.hibernate.internal.util.SerializationHelper;

import javax.persistence.Lob;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/2/2016.
 */

public class Closet implements Serializable{
    private ArrayList<ClothingArticle> clothes;
    private static final long serialVersionUID = 5440266021897153962L;

    public Closet(){
        clothes = new ArrayList<>();
    }

    public List<Outfit> generateOutfits(Season season){
        List<Outfit> outfits = new ArrayList<>();
        Outfit outfit;
        /*Generate 3 outfits*/
        for(int i = 0; i < 3; i++) {
            outfit = generateOutfit(season);
            //Add outfit to list of outfits
            outfits.add(outfit);
        }
        return outfits;
    }

    public Outfit generateOutfit(Season season){

        Outfit outfit= null;

        /*Select an article of clothing for each type*/
        ClothingArticle top = selectTop(season);
        ClothingArticle bottom = selectBottom(season);
        ClothingArticle shoes = selectAccessory(season);
        ClothingArticle accessory = selectShoes(season);

        /*If any of the article types failed to return an article*/
        if(top !=  null && bottom != null && shoes != null && accessory != null)
        {
            top.setClothingArticle(bottom);
            shoes.setClothingArticle(top);
            accessory.setClothingArticle(shoes);
            outfit = new Outfit(accessory);
        }

        //return null or full outfit
        return outfit;
    }

    private ClothingArticle selectTop(Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Top){// && outfit.stream().filter(x -> x instanceof Bottom).toArray().length == 0) {
                if (season == Season.SPRING) {
                    if (article.getType() == TopTypes.SHORTSLEEVE || article.getType() == TopTypes.QUARTERSLEEVE ||
                            article.getType() == TopTypes.CARDIGAN || article.getType() == TopTypes.DRESS ||
                            article.getType() == TopTypes.JACKET) {
                        return article;
                    }
                }
                if (season == Season.SUMMER) {
                    if (article.getType() == TopTypes.SHORTSLEEVE || article.getType() == TopTypes.QUARTERSLEEVE ||
                            article.getType() == TopTypes.CARDIGAN || article.getType() == TopTypes.DRESS) {
                        return article;
                    }
                }
                if (season == Season.FALL) {
                    if (article.getType() == TopTypes.LONGSLEEVE|| article.getType() == TopTypes.QUARTERSLEEVE ||
                            article.getType() == TopTypes.CARDIGAN || article.getType() == TopTypes.DRESS ||
                            article.getType() == TopTypes.JACKET) {
                        return article;
                    }
                }
                if (season == Season.WINTER) {
                    if (article.getType() == TopTypes.LONGSLEEVE|| article.getType() == TopTypes.QUARTERSLEEVE ||
                            article.getType() == TopTypes.CARDIGAN || article.getType() == TopTypes.DRESS ||
                            article.getType() == TopTypes.JACKET) {
                        return article;
                    }
                }
            }
        }
        return null;
    }

    private ClothingArticle selectAccessory(Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Accessories) {// && outfit.stream().filter(x -> x instanceof Bottom).toArray().length == 0) {
                if (season == Season.SPRING) {
                    if (article.getType() == AccessoryTypes.NECKLACE || article.getType() == AccessoryTypes.BRACELET ||
                            article.getType() == AccessoryTypes.RING || article.getType() == AccessoryTypes.EARRINGS ||
                            article.getType() == AccessoryTypes.HAT || article.getType() == AccessoryTypes.BELT ||
                            article.getType() == AccessoryTypes.WATCH) {
                        return article;
                    }
                }
                if (season == Season.SUMMER) {
                    if (article.getType() == AccessoryTypes.NECKLACE || article.getType() == AccessoryTypes.BRACELET ||
                            article.getType() == AccessoryTypes.RING || article.getType() == AccessoryTypes.EARRINGS ||
                            article.getType() == AccessoryTypes.HAT || article.getType() == AccessoryTypes.BELT ||
                            article.getType() == AccessoryTypes.WATCH) {
                        return article;
                    }
                }
                if (season == Season.FALL) {
                    if (article.getType() == AccessoryTypes.NECKLACE || article.getType() == AccessoryTypes.BRACELET ||
                            article.getType() == AccessoryTypes.RING || article.getType() == AccessoryTypes.EARRINGS ||
                            article.getType() == AccessoryTypes.HAT || article.getType() == AccessoryTypes.BELT ||
                            article.getType() == AccessoryTypes.WATCH || article.getType() == AccessoryTypes.SCARF) {
                        return article;
                    }
                }
                if (season == Season.WINTER) {
                    if (article.getType() == AccessoryTypes.NECKLACE || article.getType() == AccessoryTypes.BRACELET ||
                            article.getType() == AccessoryTypes.RING || article.getType() == AccessoryTypes.EARRINGS ||
                            article.getType() == AccessoryTypes.HAT || article.getType() == AccessoryTypes.BELT ||
                            article.getType() == AccessoryTypes.WATCH || article.getType() == AccessoryTypes.SCARF) {
                        return article;
                    }
                }
            }
        }
        return null;
    }

    private ClothingArticle selectShoes(Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Shoes){// && outfit.stream().filter(x -> x instanceof Bottom).toArray().length == 0) {
                if (season == Season.SPRING) {
                    if (article.getType() == ShoeTypes.SANDALS || article.getType() == ShoeTypes.ATHLETIC ||
                            article.getType() == ShoeTypes.HEELS || article.getType() == ShoeTypes.DRESS) {
                        return article;
                    }
                }
                if (season == Season.SUMMER) {
                    if (article.getType() == ShoeTypes.SANDALS || article.getType() == ShoeTypes.ATHLETIC ||
                            article.getType() == ShoeTypes.HEELS) {
                        return article;
                    }
                }
                if (season == Season.FALL) {
                    if (article.getType() == ShoeTypes.ATHLETIC || article.getType() == ShoeTypes.DRESS ||
                            article.getType() == ShoeTypes.BOOTS) {
                        return article;
                    }
                }
                if (season == Season.WINTER) {
                    if (article.getType() == ShoeTypes.DRESS || article.getType() == ShoeTypes.ATHLETIC ||
                            article.getType() == ShoeTypes.BOOTS) {
                        return article;
                    }
                }
            }
        }
        return null;
    }

    private ClothingArticle selectBottom(Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Top){// && outfit.stream().filter(x -> x instanceof Bottom).toArray().length == 0) {
                if (season == Season.SPRING) {
                    if (article.getType() == BottomTypes.SHORTPANTS || article.getType() == BottomTypes.SHORTSKIRT ||
                            article.getType() == BottomTypes.LONGPANTS || article.getType() == BottomTypes.LONGSKIRT
                            || article.getType() == BottomTypes.CAPRIS) {
                        return article;
                    }
                }
                if (season == Season.SUMMER) {
                    if (article.getType() == BottomTypes.SHORTPANTS || article.getType() == BottomTypes.SHORTSKIRT ||
                            article.getType() == BottomTypes.LONGPANTS || article.getType() == BottomTypes.LONGSKIRT) {
                        return article;
                    }
                }
                if (season == Season.FALL) {
                    if (article.getType() == BottomTypes.LONGPANTS || article.getType() == BottomTypes.SHORTSKIRT ||
                            article.getType() == BottomTypes.LONGSKIRT || article.getType() == BottomTypes.CAPRIS) {
                        return article;
                    }
                }
                if (season == Season.WINTER) {
                    if (article.getType() == BottomTypes.LONGPANTS || article.getType() == BottomTypes.LONGSKIRT) {
                        return article;
                    }
                }
            }
        }
        return null;
    }

    public void addClothingArticle( ClothingArticle clothingArticle ){
        clothes.add( clothingArticle );
    }

    public void removeClothingArticle( ClothingArticle clothingArticle ){
        clothes.remove( clothingArticle );
    }

    public ClothingArticle[] getClothes(){
        return clothes.toArray(new ClothingArticle[clothes.size()]);
    }

    public ClothingArticle findClothingArticle(ClothingArticle _clothes) {
        for (ClothingArticle cl: clothes) {
            if(_clothes == cl)
                return cl;
        }
        return null;
    }

    @Lob
    public <T> T getData(){
        return (T) SerializationHelper.serialize(this);
    }
}
