package com.comp3350.IntegrationTests;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Logic.LoginManager;
import com.comp3350.Object.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FeaturesTest {

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        DatabaseHelper dbHelper = new DatabaseHelper();
        User testUser = new User("testUser", "testUser@email.com", 22, 140, "Male", 172, "password");
        dbHelper.addData(testUser);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFeatures() {

    }
}
