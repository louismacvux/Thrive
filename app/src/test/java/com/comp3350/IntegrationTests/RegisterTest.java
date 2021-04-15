package com.comp3350.IntegrationTests;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Logic.RegisterManager;
import com.comp3350.Object.User;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegisterTest {
    //integration test of RegisterManager and DatabaseHelper classes

    private RegisterManager registerManager;
    private DatabaseHelper dbHelper;

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        dbHelper = new DatabaseHelper();
        User testUser1 = new User("userAlpha", "userAlpha@email.com", 24, 145, "Male", 170, "password");
        User testUser2 = new User("userBeta", "userBeta@email.com", 19, 120, "Female", 160, "password");
        dbHelper.addData(testUser1);
        dbHelper.addData(testUser2);
        registerManager = new RegisterManager(dbHelper);
    }

    @After
    public void tearDown() {
        dbHelper.removeUser("userAlpha");
        dbHelper.removeUser("userBeta");
        dbHelper.removeUser("userCharlie");
    }

    @Test
    public void testRegistered() {
        int num_tested = 0;
        int failed_test = 0;

        //test user already existed register successful or not
        //(with different password)
        try
        {
            num_tested++;
            assert (!registerManager.registered("userAlpha@email.com", "userAlpha", "pass", "pass", "Male", 1, "24",  "145", "170"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        //test user already existed register successful or not
        //(with different personal info)
        try
        {
            num_tested++;
            assert (!registerManager.registered("userBeta2@email.com", "userBeta", "password", "password", "Male", 1, "20",  "135", "165"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        //test new user register successful or not
        try
        {
            num_tested++;
            assert (registerManager.registered("userCharlie@email.com", "userCharlie", "password", "password", "Male", 1, "20",  "140", "172"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        System.out.println("*** REGISTER TESTS ***");
        System.out.println(num_tested + " tests run, " + (num_tested - failed_test) + " passed," + failed_test + " failed.");
    }

    @Test
    public void testUserExists() {
        int num_tested = 0;
        int failed_test = 0;

        //test user already existed
        try
        {
            num_tested++;
            assert (registerManager.userExists("userAlpha"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        //test user is not existed
        try
        {
            num_tested++;
            assert (!registerManager.userExists("unknown"));
        }
        catch (AssertionFailedError fail)
        {
            failed_test++;
            System.out.println(fail.getMessage());
        }

        System.out.println("*** USER EXIST TESTS ***");
        System.out.println(num_tested + " tests run, " + (num_tested - failed_test) + " passed," + failed_test + " failed.");
    }
}
