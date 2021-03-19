package com.comp3350;

import com.comp3350.Database.DatabaseBasic;
import com.comp3350.Object.User;

import junit.framework.AssertionFailedError;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests regarding creation of User objects, its getters/setters and toString.
 * Also, tests regarding database creation, inserts, reads, and deletes.
 *
 */
public class UnitTestI1 {
    @Test
    public void testUserObjects() throws Exception
    {
        int failedTests = 0;
        int numTests = 0;
        User testUser1 = new User();

        //test blank user creation
        try
        {
            numTests++;
            assert (testUser1 != null);
            System.out.println("Blank user successfully created...");
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        //test full constructor for users
        User testUser2 = new User(1, "myName", "myEmail", 24,
                160, "female", 160.0, "myPass");
        try
        {
            numTests++;
            assert (testUser2 != null);
            System.out.println("Regular user successfully created...");
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        //test some getters and setters
        testUser1.setAge(28);
        try
        {
            numTests++;
            assert(testUser1.getAge() == 28);
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }
        try
        {
            numTests++;
            assert(testUser1.getAge() != 915);
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        try
        {
            numTests++;
            assert(testUser2.getGender().equals("female"));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        try
        {
            numTests++;
            assert(testUser2.getGenderInt() == 1);
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }
        System.out.println("*** USER TESTS ***");
        System.out.println(numTests + " tests run, " + (numTests - failedTests) + " passed," +
                failedTests + " failed.");
    }

    @Test
    public void testDatabaseMethods() throws Exception
    {
        int failedTests = 0;
        int numTests = 0;
        DatabaseBasic dbTester = new DatabaseBasic();

        //make some Users to ASSERT adding to dbTester
        User testUser3 = new User(1, "Jolly", "jolly@gmail.com", 24,
                160, "female", 160.0, "JollyPass");
        try
        {
            numTests++;
            assert(dbTester.addData(testUser3));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }
        User testUser4 = new User(2, "Holly", "Holly@gmail.com", 25,
                160, "female", 160.0, "HollyPass");
        try
        {
            numTests++;
            assert(dbTester.addData(testUser4));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        User testUser5 = new User(3, "Polly", "Polly@gmail.com", 26,
                160, "female", 160.0, "PollyPass");
        try
        {

            assert(dbTester.addData(testUser5));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        User testUser6 = new User(4, "Sally", "Sally@gmail.com", 27,
                160, "female", 160.0, "SallyPass");
        try
        {
            numTests++;
            assert(dbTester.addData(testUser6));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        //test getSomeone
        User temp = dbTester.getSomeone(testUser3.getName());
        try
        {

            assert(temp.getName().equals(testUser3.getName()));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        //test getSomeone returns null if it can't find that user
        User testUser7 =  new User(5, "Juan Diego", "jDizzle@gmail.com", 26,
                160, "female", 160.0, "PollyPass");
        temp = dbTester.getSomeone(testUser7.getName());
        try
        {
            numTests++;
            assert(temp == null);
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        //test checkCredentials
        temp = testUser4;

        try
        {
            numTests++;
            assert(dbTester.checkCredentials(temp.getName(), temp.getPassword()));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }
        try
        {
            numTests++;
            assert(!dbTester.checkCredentials("this won't", "work"));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        //test removeUser
        try
        {
            numTests++;
            assert(dbTester.removeUser(temp));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }

        temp = testUser7;                        //not in the db
        try
        {
            numTests++;
            assert (!dbTester.removeUser(temp));
        }
        catch (AssertionFailedError fail)
        {
            failedTests++;
            System.out.println(fail.getMessage());
        }
        System.out.println("*** DATABASE TESTS ***");
        System.out.println(numTests + " tests run, " + (numTests - failedTests) + " passed," +
                failedTests + " failed.");
    }
}





