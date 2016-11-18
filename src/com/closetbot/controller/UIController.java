package com.closetbot.controller;

import com.closetbot.model.Closet;

/**
 * Created by Owner on 11/2/2016.
 */
public class UIController {
    private static UIController uiController;
    private        Closet       closet;

    private UIController(){
    }
    public static UIController getUIController(){
        if(uiController == null)
            uiController = new UIController();
        return uiController;
    }
    public void setCloset(Closet c){
        closet = c;
    }
    public Closet getCloset(){
        return closet;
    }
    public Object[][] getClosetData(){
        return null;
    }
}
