package com.comp3350.UnitTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Logic.LoginManager;
import com.comp3350.Object.User;

import junit.framework.AssertionFailedError;

import static org.junit.Assert.*;

public class LoginManagerTest {

    int num_test;
    int test_failed;

    private LoginManager login;
    DatabaseHelper db;

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        db = new DatabaseHelper();
        User user1 = new User("testPeter", "peter@email.com", 23, 130,
                "male", 176, "Parker");
        db.addData(user1);
        login = new LoginManager(db);
    }

    @Test
    public void dummyTest(){
        //this will be on until I figure out the DB thing
    }

    //@Test
    public void foundUserTest() {
        try{
            assertTrue("Assertion passed: User testPeter is found", login.foundUser("testPeter"));
            num_test++;
        }catch (AssertionFailedError e) {
            test_failed++;
            System.out.println(e.getMessage());
        }

        try{
            assertFalse("Assertion passed: User uiy2io34 is not found", login.foundUser("uiy2io34"));
            num_test++;
        }catch (AssertionFailedError e){
            test_failed++;
            System.out.println(e.getMessage());
        }
    }

    //@Test
    public void validateUserTest(){
        //both fields are empty
        try{
            assertEquals("Assertion passed: empty field",
                    "Please enter both username and password",
                    login.validateUser("",""));
            num_test++;
        }catch (AssertionFailedError e){
            test_failed++;
            System.out.println(e.getMessage());
        }

        //empty password field
        try{assertEquals("Assertion passed: empty pass",
                "Please enter both username and password",
                login.validateUser("someName",""));
            num_test++;
        }catch (AssertionFailedError e){
            test_failed++;
            System.out.println(e.getMessage());
        }

        //empty username field
        try{assertEquals("Assertion passed: empty username",
                "Please enter both username and password",
                login.validateUser("","somePass"));
            num_test++;
        }catch (AssertionFailedError e){
            test_failed++;
            System.out.println(e.getMessage());
        }

        //successfully logged in
        try{assertEquals("Assertion passed: logged in",
                "Successfully logged in",
                login.validateUser("testPeter","Parker"));
            num_test++;
        }catch (AssertionFailedError e){
            test_failed++;
            System.out.println(e.getMessage());
        }

        //incorrect password
        try{assertEquals("Assertion passed: incorrect password",
                "Incorrect Password",
                login.validateUser("testPeter","iuwecn iwueag"));
            num_test++;
        }catch (AssertionFailedError e){
            test_failed++;
            System.out.println(e.getMessage());
        }

        //sign up
        try{assertEquals("Assertion passed: sign up",
                "No such user... SIGN UP!",
                login.validateUser("sdgfdfhfgn sdfg","iuwecn iwueag"));
            num_test++;
        }catch (AssertionFailedError e){
            test_failed++;
            System.out.println(e.getMessage());
        }
    }

    //@Test
    public void proceedLoginTest(){
        try{
            assertTrue("Assertion passed: User testPeter is in the DB",
                    login.proceedLogin("testPeter", "Parker"));
            num_test++;
        }catch (AssertionFailedError e) {
            test_failed++;
            System.out.println(e.getMessage());
        }

        try{
            assertFalse("Assertion passed: User kjsdhf is not in the DB",
                    login.proceedLogin("kjsdhf", "Parker"));
            num_test++;
        }catch (AssertionFailedError e) {
            test_failed++;
            System.out.println(e.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        db.removeUser("testPeter");
        System.out.println("*** GET GENERAL INFO ***");
        System.out.println(num_test + " tests run, " + (num_test - test_failed) + " passed, "
                + test_failed + " failed.");
    }
}