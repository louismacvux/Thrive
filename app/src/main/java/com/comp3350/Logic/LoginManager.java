package com.comp3350.Logic;

import com.comp3350.Database.DatabaseHelper;


public class LoginManager {

    private final DatabaseHelper db;
//    private String loginErrorMessage = "";

    public LoginManager(DatabaseHelper db){
        this.db = db;
    }

    public boolean proceedLogin (String username, String password){
        return db.checkCredentials(username, password);
    }

    public boolean foundUser (String username){
        return db.checkName(username);
    }

//    //returns true if login can proceed
//    public boolean loginSuccess(String username, String password){
//        return userValidated(username, password);
//    }//end loginSuccess

    //returns true if the username and password is found in user database
//    public boolean userValidated(String username, String password){
//        boolean checkUserPass = dbHelper.checkCredentials(username, password);
//
//        //if checkUserPass failed but the username was found
//        if (!checkUserPass && dbHelper.checkName(username)) {
//            loginErrorMessage += "Incorrect Password\n";
//        }
//        else
//        {
//            loginErrorMessage += "No such user... Sign Up!\n";
//        }
//
//        return checkUserPass;
//    }//end userValidated

//    public String getLoginErrorMessage() {
//        return loginErrorMessage;
//    }
}//end class
