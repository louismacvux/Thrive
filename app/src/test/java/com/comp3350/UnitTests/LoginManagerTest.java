package com.comp3350.UnitTests;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Logic.LoginManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)

public class LoginManagerTest {

    private LoginManager login;
    DatabaseHelper dbmock;

    @Before
    public void setUp() {
        dbmock = mock(DatabaseHelper.class);
        login = new LoginManager(dbmock);
    }

    @Test
    public void validateUserTest(){
        //since dbmock is a mock database, we need to tell
        // the method it called what value to return.
        //1st "thenReturn" is for first call, 2nd "thenReturn" is for 2nd call,...
        when(dbmock.checkCredentials(Mockito.anyString(), Mockito.anyString())).thenReturn(true).thenReturn(false).thenReturn(false);
        when(dbmock.checkName(Mockito.anyString())).thenReturn(true).thenReturn(false);

        String toast1 = login.validateUser("testPeter","Parker");
        assertNotNull(toast1);
        assertEquals(toast1, "Successfully logged in"); //1st time checkCredentials run returns true

        String toast2 = login.validateUser("testPeter","Parker");
        assertNotNull(toast2);
        assertEquals(toast2, "Incorrect Password"); //2nd time checkCredentials run returns false

        //Mockito.anyString().isEmpty = true
        String toast3 = login.validateUser(Mockito.anyString(), "Parker");
        assertNotNull(toast3);
        assertEquals(toast3, "Please enter both username and password");

        String toast4 = login.validateUser("testPeter", Mockito.anyString());
        assertNotNull(toast4);
        assertEquals(toast4, "Please enter both username and password");

        String toast5 = login.validateUser("testPeter", "Parker");
        assertNotNull(toast5);
        assertEquals(toast5, "No such user... SIGN UP!"); //last call to checkCredentials and checkName returns false

        //verify the calls on mock object
        verify(dbmock, times(2)).checkName("testPeter");
        verify(dbmock, times(3)).checkCredentials("testPeter", "Parker");
        verifyNoMoreInteractions(dbmock);
    }

}