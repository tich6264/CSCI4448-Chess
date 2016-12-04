package com.closetbot.controller;

import com.closetbot.model.*;

/**
 * Created by Owner on 11/2/2016.
 */
public class UIController {
    private static UIController uiController;
    private User         user;
    private DatabaseProxy db = new DatabaseProxy();
    private UIController() {
    }

    public static UIController getUIController() {
        if (uiController == null)
            uiController = new UIController();
        return uiController;
    }

    public void setUser(User u){
        user = u;
    }

    /*
     * for use in JViewOutfitClosetPanel
     */
    public OutfitCloset getOutfitCloset() {
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
            Object[][]        toRet   = new Object[clothes.length][6];
            int               i       = 0;
            for (ClothingArticle cl : clothes) {
                Object[] toAdd = new Object[6];
                toAdd[0] = cl.getClass().getSimpleName();
                toAdd[1] = cl.getType().name();
                toAdd[2] = cl.getColor().name();
                toAdd[3] = cl.getPattern().name();
                toAdd[4] = cl.getSeason().name();
                toAdd[5] = cl;
                toRet[i++] = toAdd;
            }
            return toRet;
        }
        return null;
    }

    public void removeOutfit(Outfit o) {
        assert(user != null);
        assert(user.getOutfits() != null);
        if (o != null){
            user.getOutfits().removeOutfit(o);
            db.saveUser(user);
        }
    }
    public void saveOutfit(Outfit o){
        assert(user != null);
        assert(user.getOutfits() != null);
        if (o != null){
            user.getOutfits().addOutfit(o);
            db.saveUser(user);
        }
    }

    public void addClothingArticle(Type subType, Color color, Pattern pattern, Season season) {
        assert(user != null);
        assert(user.getCloset() != null);
        ClothingArticleFactory factory = new ClothingArticleFactory();
        ClothingArticle        cl      = factory.createClothingArticle(subType, color, pattern, season);
        user.getCloset().addClothingArticle(cl);
        db.saveUser(user);
    }

    public void removeClothingArticle(ClothingArticle cl) {
        user.getCloset().removeClothingArticle(cl);
        db.saveUser(user);
    }

    public void editClothingArticle(Type subType, Color color, Pattern pattern, Season season) {
        assert(user != null);
        assert(user.getCloset() != null);

        // TODO: updateClothingArticle in ClothingArticleFactory;
//        user.getCloset().addClothingArticle(c1);
//        db.saveUser(user);
    }
}
