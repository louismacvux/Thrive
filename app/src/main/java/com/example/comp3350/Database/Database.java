package com.example.comp3350.Database;

import com.example.comp3350.Object.User;

public interface Database {

    boolean addData(User newUser);
    User getSomeone(String name);
    boolean checkCredentials(String givenName, String givenPassword);
    boolean checkName(String givenName);
    boolean removeUser(User input);
}
