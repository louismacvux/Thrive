package com.comp3350.Logic;

import com.comp3350.Database.DatabaseHelper;

public class LoginManager {

    private final DatabaseHelper db;

    public LoginManager(DatabaseHelper db){
        this.db = db;
    }

    public String validateUser(String userName, String userPass){
           String toast = "";
           if (userName.isEmpty() || userPass.isEmpty()){
               toast = "Please enter both username and password";
           }
           else {
               if (db.checkCredentials(userName, userPass)){
                    toast = "Successfully logged in";
               }else if (db.checkName(userName)){
                   toast = "Incorrect Password";
               }else {
                   toast = "No such user... SIGN UP!";
               }
           }
           return toast;
    }


}//end class
