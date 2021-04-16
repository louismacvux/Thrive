package com.comp3350.IntegrationTests;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Logic.LoginManager;
import com.comp3350.Object.User;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginTest {
    //integration test of LoginManager and DatabaseHelper classes

    private LoginManager loginManager;
    private DatabaseHelper dbHelper;

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        dbHelper = new DatabaseHelper();
        User testUser1 = new User("testUser1", "testUser1@email.com", 20, 150, "Male", 175, "password");
        User testUser2 = new User("testUser2", "testUser2@email.com", 22, 140, "Male", 170, "password");
        dbHelper.addData(testUser1);
        dbHelper.addData(testUser2);
        loginManager = new LoginManager(dbHelper);
    }

    @After
    public void tearDown() {
        dbHelper.removeUser("testUser1");
        dbHelper.removeUser("testUser2");
    }

    @Test
    public void testValidateUser() {
        int num_tested = 0;
        int failed_test = 0;

        //test testUser1 login successful or not
        try
        {
            num_tested++;
            assert (loginManager.validateUser("testUser1", "password").equals("Successfully logged in"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        //test testUser2 login successful or not
        try
        {
            num_tested++;
            assert (loginManager.validateUser("testUser2", "password").equals("Successfully logged in"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        //test user who is not registered login successful or not
        try
        {
            num_tested++;
            assert (loginManager.validateUser("notRegistered", "password").equals("No such user... SIGN UP!"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        //test testUser1 with wrong password login successful or not
        try
        {
            num_tested++;
            assert (loginManager.validateUser("testUser1", "wrongPassword").equals("Incorrect Password"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        System.out.println("*** LOGIN TESTS ***");
        System.out.println(num_tested + " tests run, " + (num_tested - failed_test) + " passed," + failed_test + " failed.");
    }
}
