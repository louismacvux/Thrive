package com.example.comp3350;

import java.util.ArrayList;

public class DatabaseBasic implements Database
{
    ArrayList data;
    
    public DatabaseBasic()
    {
        this.data = new ArrayList();
    }
    
    public boolean addData(User newUser)
    {
        //assume we didn't add data(item) to the table
        boolean result = false;
       
        data.add(newUser);

        for (int i = 0; i < data.size(); i++)
        {
            if (data.get(i) == newUser)
            {
                result = true;
            }
        }
        return result;
    }
    public User getSomeone(String name)
    {
        User temp;
        User result = null;

        for (int i = 0; i < data.size(); i++)
        {
            temp = (User)data.get(i);
            if (temp.getName().equals(name))
            {
                result = temp;
            }
        }
        return result;
    }
    public boolean checkCredentials(String givenName, String givenPassword)
    {
        //assume name and pass don't match
        boolean result = false;
        User temp;

        for (int i = 0; i < data.size(); i++)
        {
            temp = (User)data.get(i);
            if (temp.getName().equals(givenName) &&
                    temp.getPassword().equals(givenPassword))
            {
                result = true;
            }
        }
        return result;
    }

    public boolean checkName(String givenName) {
        //assume name doesn't match
        boolean result = false;
        User temp;

        for (int i = 0; i < data.size() && !result; i++) {
            temp = (User) data.get(i);
            if (temp.getName().equals(givenName)) {
                result = true;
            }
        }

        return result;
    }

    public boolean removeUser(User input)
    {
        //assume we did not remove the user
        boolean result = false;
        User temp;

        for (int i = 0; i < data.size() && !result; i++)
        {
            temp = (User) data.get(i);
            if (temp == input)
            {
                data.remove(i);
                System.out.println("User " + temp.getName() + " has been deleted");
                result = true;
            }
        }

        if (!result)
        {
            System.out.println("ERROR: USER "+ input.getName() +
                    " WAS NOT FOUND, WAS NOT REMOVED");
        }

        return result;
    }
}
