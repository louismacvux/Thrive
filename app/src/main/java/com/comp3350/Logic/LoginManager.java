package com.comp3350.Logic;

import com.comp3350.Database.DatabaseHelper;


public class LoginManager {

    private final DatabaseHelper db;

    public LoginManager(DatabaseHelper db){
        this.db = db;
    }

    public boolean proceedLogin (String username, String password){
        return db.checkCredentials(username, password);
    }

    public boolean foundUser (String username){
        return db.checkName(username);
    }

}//end class
