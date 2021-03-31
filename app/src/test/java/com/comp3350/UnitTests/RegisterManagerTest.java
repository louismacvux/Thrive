package com.comp3350.UnitTests;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Logic.RegisterManager;
import com.comp3350.Object.User;
import com.comp3350.UI.RegisterActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegisterManagerTest {

//    DatabaseHelper db = new DatabaseHelper();
    RegisterManager manager = new RegisterManager();
    User u1;

    @Before
    public void setUp() throws Exception {
        u1 = new User("emma", "emma@gmail.com", 18, 140,
                "female", 160.8, "emma1234");
    }

//    @Test
//    public void registered() {
//        //pw != confirmpw
//        assert(!manager.registered("bob@gmail.com", "bob", "bob1234", "bab1234",
//                "male", 32, 140, 170));
//
//        //registered properly
//        assert(manager.registered("bob@gmail.com", "bob", "bob1234", "bob1234",
//                "male", 32, 140, 170));
//
//        //does it return false when there is the same user?
//        assert(!manager.registered("bob@gmail.com", "bob", "bob1234", "bob1234",
//                "male", 32, 140, 170));
//    }

    @Test
    public void fieldEmpty() {
        assert(!manager.fieldEmpty("bob@gmail.com", "bob", "bob1234", "bob1234",
                "male", 32, 140, 170));

        //empty fields
        assert(manager.fieldEmpty("", "bob", "bob1234", "bob1234",
                "male", 32, 140, 170)); //empty email
        assert(manager.fieldEmpty("bob@gmail.com", "", "bob1234", "bob1234",
                "male", 32, 140, 170)); //empty username
        assert(manager.fieldEmpty("bob@gmail.com", "bob", "", "bob1234",
                "male", 32, 140, 170)); //empty pw
        assert(manager.fieldEmpty("bob@gmail.com", "bob", "bob1234", "",
                "male", 32, 140, 170)); //empty confirmpw
        assert(manager.fieldEmpty("bob@gmail.com", "bob", "bob1234", "bob1234",
                "male", 0, 0, 0)); //invalid numbers
    }

//    @Test
//    public void userExists() {
//        assert(manager.userExists("emma"));
//        assert(!manager.userExists("shoudnotbethere"));
//    }

    @Test
    public void pwMatches() {
        String pw = "thisisPassword";
        String confirm = "thisisPassword";
        String wrongConfirm = "thisisWrong";

        assert(manager.pwMatches(pw, confirm));
        assert(!manager.pwMatches(pw, wrongConfirm));
    }

    @Test
    public void validateEmail(){
        String email = u1.getEmail();
        String tooManyChars = "thisisaverysuperlongandhumongousemail@gmail.com";
        String wrongFormat1 = "emma@gmail";
        String wrongFormat2 = "emmagmail.com";

        assert(manager.validateEmail(email));
        assert(!manager.validateEmail(""));
        assert(!manager.validateEmail(tooManyChars));
        assert(!manager.validateEmail(wrongFormat1));
        assert(!manager.validateEmail(wrongFormat2));
    }

    @Test
    public void validateName(){
        String name = u1.getName();
        String tooLong = "thisisaveryverylongusername";
        String withSpaces = "emma Johnson";

        assert(manager.validateName(name));
        assert(!manager.validateName(""));
        assert(!manager.validateName(tooLong));
        assert(!manager.validateName(withSpaces));

    }

    @Test
    public void validatePass(){
        String pw = u1.getPassword();
        String tooLong = "thisisaveryverylongpassword";
        String withSpaces = "emma 1234";

        assert(manager.validatePass(pw));
        assert(!manager.validatePass(""));
        assert(!manager.validatePass(tooLong));
        assert(!manager.validatePass(withSpaces));
    }


    @After
    public void tearDown() throws Exception {
        u1 = null;
    }
}