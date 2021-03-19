package com.comp3350.IntegrationTests;

import com.comp3350.Database.DatabaseHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

public class LoginTest {

    private DatabaseHelper dbHelper;

    @Before
    public void setUp() throws Exception {
        dbHelper = new DatabaseHelper(RuntimeEnvironment.application);
    }

    @Test
    public void proceedLogin() {
    }

}
