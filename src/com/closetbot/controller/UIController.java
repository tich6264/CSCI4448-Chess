package com.closetbot.controller;

import com.closetbot.model.*;

/**
 * Created by Owner on 11/2/2016.
 */
public class UIController {
    private static UIController uiController;
    private static User         user;
    private UIController() {
    }

    public static UIController getUIController() {
        if (uiController == null)
            uiController = new UIController();
        return uiController;
    }

    public static void setUser(User u){
        user = u;
    }

    /*
     * for use in JViewOutfitClosetPanel
     */
    public static OutfitCloset getOutfitCloset() {
        return user.getOutfits();
    }

    public Closet getCloset() {
        return user.getCloset();
    }

    /*
     * For use in JViewClosetPanel
     */
    public Object[][] getClosetData() {
        if (user.getCloset() != null) {
            ClothingArticle[] clothes = user.getCloset().getClothes();
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

    public void removeClothingArticle(ClothingArticle cl) {
        user.getCloset().removeClothingArticle(cl);
    }

    public void removeOutfit(Outfit o) {
        assert(user != null);
        assert (user.getOutfits() != null);
        if (o != null)
            user.getOutfits().removeOutfit(o);
    }

    public void addClothingArticle(Type subType, Color color, Pattern pattern, Season season) {
        assert(user != null);
        assert (user.getCloset() != null);
        ClothingArticleFactory factory = new ClothingArticleFactory();
        ClothingArticle        cl      = factory.createClothingArticle(subType, color, pattern, season);
        user.getCloset().addClothingArticle(cl);
    }
}
