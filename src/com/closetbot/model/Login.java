package com.closetbot.model;

import com.closetbot.controller.DatabaseProxy;
import com.closetbot.controller.UIController;

/**
 * Created by Tiffany on 11/30/2016.
 */
public class Login {
    public static boolean authentication(String username, String password) {
        DatabaseProxy dbproxy = new DatabaseProxy();
        User u = dbproxy.getUser(username,password);

        UIController uiController = UIController.getUIController();
        uiController.setUser(u);

        return u != null;
    }
    public static boolean register(String username,String password ){
        DatabaseProxy dbproxy = new DatabaseProxy();
        User u = dbproxy.createUser(username,password);

        UIController uiController = UIController.getUIController();
        uiController.setUser(u);

        return u != null;
    }
}
