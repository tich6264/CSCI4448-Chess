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
            if(outfit != null)
                outfits.add(outfit);
        }
        return outfits;
    }

    public Outfit generateOutfit(Season season){

        Outfit outfit= null;

        /*Select an article of clothing for each type*/
        Top top = selectTop(season);
        Bottom bottom = selectBottom(season);
        Shoes shoes = selectShoes(season);
        Accessories accessory =selectAccessory(season);

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

    private Top selectTop(Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Top){
                Top toRet = (Top) article;
                if (season == Season.SPRING) {
                    if (toRet.getType() == TopTypes.SHORTSLEEVE || toRet.getType() == TopTypes.QUARTERSLEEVE ||
                            toRet.getType() == TopTypes.CARDIGAN || toRet.getType() == TopTypes.DRESS ||
                            toRet.getType() == TopTypes.JACKET) {
                        return toRet;
                    }
                }
                if (season == Season.SUMMER) {
                    if (toRet.getType() == TopTypes.SHORTSLEEVE || toRet.getType() == TopTypes.QUARTERSLEEVE ||
                            toRet.getType() == TopTypes.CARDIGAN || toRet.getType() == TopTypes.DRESS) {
                        return toRet;
                    }
                }
                if (season == Season.FALL) {
                    if (toRet.getType() == TopTypes.LONGSLEEVE|| toRet.getType() == TopTypes.QUARTERSLEEVE ||
                            toRet.getType() == TopTypes.CARDIGAN || toRet.getType() == TopTypes.DRESS ||
                            toRet.getType() == TopTypes.JACKET) {
                        return toRet;
                    }
                }
                if (season == Season.WINTER) {
                    if (toRet.getType() == TopTypes.LONGSLEEVE|| toRet.getType() == TopTypes.QUARTERSLEEVE ||
                            toRet.getType() == TopTypes.CARDIGAN || toRet.getType() == TopTypes.DRESS ||
                            toRet.getType() == TopTypes.JACKET) {
                        return toRet;
                    }
                }
            }
        }
        return null;
    }

    private Accessories selectAccessory(Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Accessories) {// && outfit.stream().filter(x -> x instanceof Bottom).toArray().length == 0) {
                Accessories toRet = (Accessories) article;
                if (season == Season.SPRING) {
                    if (toRet.getType() == AccessoryTypes.NECKLACE || toRet.getType() == AccessoryTypes.BRACELET ||
                            toRet.getType() == AccessoryTypes.RING || toRet.getType() == AccessoryTypes.EARRINGS ||
                            toRet.getType() == AccessoryTypes.HAT || toRet.getType() == AccessoryTypes.BELT ||
                            toRet.getType() == AccessoryTypes.WATCH) {
                        return toRet;
                    }
                }
                if (season == Season.SUMMER) {
                    if (toRet.getType() == AccessoryTypes.NECKLACE || toRet.getType() == AccessoryTypes.BRACELET ||
                            toRet.getType() == AccessoryTypes.RING || toRet.getType() == AccessoryTypes.EARRINGS ||
                            toRet.getType() == AccessoryTypes.HAT || toRet.getType() == AccessoryTypes.BELT ||
                            toRet.getType() == AccessoryTypes.WATCH) {
                        return toRet;
                    }
                }
                if (season == Season.FALL) {
                    if (toRet.getType() == AccessoryTypes.NECKLACE || toRet.getType() == AccessoryTypes.BRACELET ||
                            toRet.getType() == AccessoryTypes.RING || toRet.getType() == AccessoryTypes.EARRINGS ||
                            toRet.getType() == AccessoryTypes.HAT || toRet.getType() == AccessoryTypes.BELT ||
                            toRet.getType() == AccessoryTypes.WATCH || toRet.getType() == AccessoryTypes.SCARF) {
                        return toRet;
                    }
                }
                if (season == Season.WINTER) {
                    if (toRet.getType() == AccessoryTypes.NECKLACE || toRet.getType() == AccessoryTypes.BRACELET ||
                            toRet.getType() == AccessoryTypes.RING || toRet.getType() == AccessoryTypes.EARRINGS ||
                            toRet.getType() == AccessoryTypes.HAT || toRet.getType() == AccessoryTypes.BELT ||
                            toRet.getType() == AccessoryTypes.WATCH || toRet.getType() == AccessoryTypes.SCARF) {
                        return toRet;
                    }
                }
            }
        }
        return null;
    }

    private Shoes selectShoes(Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Shoes){// && outfit.stream().filter(x -> x instanceof Bottom).toArray().length == 0) {
                Shoes toRet = (Shoes) article;
                if (season == Season.SPRING) {
                    if (toRet.getType() == ShoeTypes.SANDALS || toRet.getType() == ShoeTypes.ATHLETIC ||
                            toRet.getType() == ShoeTypes.HEELS || toRet.getType() == ShoeTypes.DRESS) {
                        return toRet;
                    }
                }
                if (season == Season.SUMMER) {
                    if (toRet.getType() == ShoeTypes.SANDALS || toRet.getType() == ShoeTypes.ATHLETIC ||
                            toRet.getType() == ShoeTypes.HEELS) {
                        return toRet;
                    }
                }
                if (season == Season.FALL) {
                    if (toRet.getType() == ShoeTypes.ATHLETIC || toRet.getType() == ShoeTypes.DRESS ||
                            toRet.getType() == ShoeTypes.BOOTS) {
                        return toRet;
                    }
                }
                if (season == Season.WINTER) {
                    if (toRet.getType() == ShoeTypes.DRESS || toRet.getType() == ShoeTypes.ATHLETIC ||
                            toRet.getType() == ShoeTypes.BOOTS) {
                        return toRet;
                    }
                }
            }
        }
        return null;
    }

    private Bottom selectBottom(Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Bottom){// && outfit.stream().filter(x -> x instanceof Bottom).toArray().length == 0) {
                Bottom toRet = (Bottom) article;
                if (season == Season.SPRING) {
                    if (toRet.getType() == BottomTypes.SHORTPANTS || toRet.getType() == BottomTypes.SHORTSKIRT ||
                            toRet.getType() == BottomTypes.LONGPANTS || toRet.getType() == BottomTypes.LONGSKIRT
                            || toRet.getType() == BottomTypes.CAPRIS) {
                        return toRet;
                    }
                }
                if (season == Season.SUMMER) {
                    if (toRet.getType() == BottomTypes.SHORTPANTS || toRet.getType() == BottomTypes.SHORTSKIRT ||
                            toRet.getType() == BottomTypes.LONGPANTS || toRet.getType() == BottomTypes.LONGSKIRT) {
                        return toRet;
                    }
                }
                if (season == Season.FALL) {
                    if (toRet.getType() == BottomTypes.LONGPANTS || toRet.getType() == BottomTypes.SHORTSKIRT ||
                            toRet.getType() == BottomTypes.LONGSKIRT || toRet.getType() == BottomTypes.CAPRIS) {
                        return toRet;
                    }
                }
                if (season == Season.WINTER) {
                    if (toRet.getType() == BottomTypes.LONGPANTS || toRet.getType() == BottomTypes.LONGSKIRT) {
                        return toRet;
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
