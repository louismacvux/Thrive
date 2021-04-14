package com.comp3350.UnitTests;

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
public class UserTest {
    @Test
    public void testUserObjects() {
        User testUser1 = new User();

        //test blank user creation
        assert (testUser1 != null);

        //test full constructor for users
        User testUser2 = new User("myName", "myEmail", 24,
                160, "Female", 160.0, "myPass");
        assert (testUser2 != null);

        //test some getters and setters
        assert(testUser1.getAge() != 915);
        assert(testUser2.getGender().equals("Female"));
        assert(testUser2.getGenderInt() == 1);
    }

    @Test
    public void testDatabaseMethods() {
        DatabaseBasic dbTester = new DatabaseBasic();

        //make some Users to ASSERT adding to dbTester
        User testUser3 = new User("Jolly", "jolly@gmail.com", 24,
                160, "Female", 160.0, "JollyPass");
        assert(dbTester.addData(testUser3));

        User testUser4 = new User("Holly", "Holly@gmail.com", 25,
                160, "Female", 160.0, "HollyPass");
        assert(dbTester.addData(testUser4));

        User testUser5 = new User("Polly", "Polly@gmail.com", 26,
                160, "Female", 160.0, "PollyPass");
        assert(dbTester.addData(testUser5));

        User testUser6 = new User("Sally", "Sally@gmail.com", 27,
                160, "Female", 160.0, "SallyPass");
        assert(dbTester.addData(testUser6));

        //test getSomeone
        User temp = dbTester.getSomeone(testUser3.getName());
        assert(temp.getName().equals(testUser3.getName()));

        //test getSomeone returns null if it can't find that user
        User testUser7 =  new User("Juan Diego", "jDizzle@gmail.com", 26,
                160, "Female", 160.0, "PollyPass");
        temp = dbTester.getSomeone(testUser7.getName());
        assert(temp == null);

        //test checkCredentials
        temp = testUser4;
        assert(dbTester.checkCredentials(temp.getName(), temp.getPassword()));
        assert(!dbTester.checkCredentials("this won't", "work"));

        //test removeUser
        assert(dbTester.removeUser(temp.getName()));
        temp = testUser7;                        //not in the db
        assert (!dbTester.removeUser(temp.getName()));

    }
}





