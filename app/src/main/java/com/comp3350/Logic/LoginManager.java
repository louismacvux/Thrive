package com.comp3350.Logic;

import com.comp3350.Database.DatabaseHelper;

public class LoginManager {

    private final DatabaseHelper db;

    public LoginManager(DatabaseHelper db){
        this.db = db;
    }

    public boolean proceedLogin(String username, String password){
        return db.checkCredentials(username, password);
    }

    public String validateUser(String userName, String userPass){
           String toast = "";
           if (userName.isEmpty() || userPass.isEmpty()){
               toast = "Please enter both username and password";
           }
           else {
               if (proceedLogin(userName, userPass)){
                    toast = "Successfully logged in";
               }else if (foundUser(userName)){
                   toast = "Incorrect Password";
               }else {
                   toast = "No such user... SIGN UP!";
               }
           }
           return toast;
    }

    public boolean foundUser(String username){
        return db.checkName(username);
    }

}//end class
