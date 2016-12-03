package com.closetbot.model;

/**
 * Created by Tiffany on 11/30/2016.
 */
public class Login
{
    public static boolean authentication(String username, String password){

        //temporary hardcoded username/password
        if(username.equals("bob") && password.equals("password")){
            return true;
        }
        return false;
    }

}
