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


    /*
    public void selectBottom(article) {
        for (ClothingArticle article : clothes) {

            if (article.getType() == BottomTypes.SHORTPANTS || article.getType() == BottomTypes.SHORTSKIRT) {
                //toRet.add(article);
                //chosen = true;
                if (curr == null)
                    curr = article;
                else {
                    article.setClothingArticle(curr);
                    curr = article;
                }
                chosen.add(article);
                outfitSize++;
            }
    }
    public void selectAccessory(clothes, season) {
    }
    public void selectShoes(clothes, season) {
    }
*/
    public Outfit generateOutfits(Season season){
        List<Outfit> outfits = new ArrayList<>();
        Outfit outfit= null;
        int outfitSize = 0;
        ClothingArticle article;


            //while what you have is not a complete outfit
     //   while(!(curr instanceof Outfit)) {
        ClothingArticle top = selectTop(clothes, season);
        ClothingArticle bottom = selectTop(clothes, season);
        ClothingArticle shoes = selectTop(clothes, season);
        ClothingArticle accessory = selectTop(clothes, season);
        if(top !=  null && bottom != null && shoes != null && accessory != null)
        {
            top.setClothingArticle(bottom);
            shoes.setClothingArticle(top);
            accessory.setClothingArticle(shoes);
            outfit = new Outfit(accessory);

            //outfits.add(outfit);
        }
        return outfit;
    }
    /*
    public List<Outfit> Outfits(){

    }
    */

    private ClothingArticle selectTop(List<ClothingArticle> outfit, Season season) {
        for (ClothingArticle article : clothes) {
            if (article instanceof Top && outfit.stream().filter(x -> x instanceof Bottom).toArray().length == 0) {
                if (season == Season.SPRING) {
                    if (article.getType() == BottomTypes.SHORTPANTS || article.getType() == BottomTypes.SHORTSKIRT) {
                        //toRet.add(article);
                        //chosen = true;
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
