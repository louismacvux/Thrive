package com.example.comp3350;

public interface Database {

    boolean addData(User newUser);
    User getSomeone(String name);
    boolean checkCredentials(String givenName, String givenPassword);
    boolean checkName(String givenName);
    boolean removeUser(User input);
}
