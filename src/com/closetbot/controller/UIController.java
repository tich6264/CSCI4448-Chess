package com.closetbot.controller;

import com.closetbot.model.Closet;
import com.closetbot.model.ClothingArticle;
import com.closetbot.model.Outfit;
import com.closetbot.model.OutfitCloset;

/**
 * Created by Owner on 11/2/2016.
 */
public class UIController {
    private static UIController uiController;
    private static Closet       closet;
    private static OutfitCloset outfitCloset;

    private UIController() {
    }

    public static UIController getUIController() {
        if (uiController == null)
            uiController = new UIController();
        return uiController;
    }

    /*
     * for use in JViewOutfitClosetPanel
     */
    public static OutfitCloset getOutfitCloset() {
        return outfitCloset;
    }

    public static void setOutfitCloset(OutfitCloset outfitCloset) {
        UIController.outfitCloset = outfitCloset;
    }

    public void setCloset(Closet c) {
        closet = c;
    }

    public Closet getCloset() {
        return closet;
    }

    /*
     * For use in JViewClosetPanel
     */
    public Object[][] getClosetData() {
        if(closet != null){
            ClothingArticle[] clothes = closet.getClothes();
            Object[][]        toRet   = new Object[5][clothes.length];
            int               i       = 0;
            for (ClothingArticle cl : clothes) {
                Object[] toAdd = new Object[5];
                toAdd[0] = cl.getType().name();
                toAdd[1] = cl.getColor().name();
                toAdd[2] = cl.getPattern().name();
                toAdd[3] = cl.getSeason().name();
                toAdd[4] = cl;
                toRet[i++] = toAdd;
            }
            return toRet;
        }
        return null;
    }
    public void removeClothingArticle(ClothingArticle cl){
        closet.removeClothingArticle(cl);
    }
    public void removeOutfit(Outfit o){
        if(o != null)
            outfitCloset.removeOutfit(o);
    }
}
