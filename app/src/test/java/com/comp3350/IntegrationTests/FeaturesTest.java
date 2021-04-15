package com.comp3350.IntegrationTests;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Object.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FeaturesTest {
    private DatabaseHelper dbHelper;

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        dbHelper = new DatabaseHelper();
        User testUser = new User("testUser", "testUser@email.com", 22, 140, "Male", 172, "password");
        dbHelper.addData(testUser);
    }

    @After
    public void tearDown() {
        dbHelper.removeUser("testUser");
    }

    @Test
    public void testFeatures() {
    }
}
