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

    RegisterManager manager;

    @Before
    public void setUp() {
        manager = new RegisterManager();
    }

    @Test
    public void parseInt(){
        String string_int = "22";
        String string_double = "24.8";
        String string_long = "22222222222222222222";
        String string = "Thisisstring";
        String zero = "0";

        assert(manager.parseInt(string_int, "test") == 22);
        assert(manager.parseInt(string_double, "test") == -1);
        assert(manager.parseInt(string_long, "test") == -1);
        assert(manager.parseInt(string, "test") == -1);
        assert(manager.parseInt(zero, "test") == 0);
    }

    @Test
    public void parseDouble(){
        String string_double = "24.8";
        String string_int = "25";
        String string = "Thisisstring";
        String zero = "0";

        assert(manager.parseDouble(string_double, "test") == 24.8);
        assert(manager.parseDouble(string_int, "test") == 25);
        assert(manager.parseDouble(string, "test") == -1);
        assert(manager.parseDouble(zero, "test") == 0);
    }

    @Test
    public void radioBtnClicked(){
        assert(manager.radioBtnClicked(1, "test button"));
        assert(manager.radioBtnClicked(0, "test button"));
        assert(!manager.radioBtnClicked(-1, "test button"));
    }

    @Test
    public void validateEmail(){
        String email = "emma@gmail.com";
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
        String name = "emma";
        String tooLong = "thisisaveryverylongusername";
        String withSpaces = "emma Johnson";

        assert(manager.validateName(name));
        assert(!manager.validateName(""));
        assert(!manager.validateName(tooLong));
        assert(!manager.validateName(withSpaces));

    }

    @Test
    public void validatePass(){
        String pw = "emma1234";
        String tooLong = "thisisaveryveryveryverylongpassword";
        String tooShort = "short";
        String withSpaces = "emma 1234";

        assert(manager.validatePass(pw));
        assert(!manager.validatePass(""));
        assert(!manager.validatePass(tooLong));
        assert(!manager.validatePass(tooShort));
        assert(!manager.validatePass(withSpaces));
    }

    @Test
    public void validateConfirmPass() {
        String pw = "thisisPassword";
        String confirm = "thisisPassword";
        String wrongConfirm = "thisisWrong";

        assert(manager.validateConfirmPass(pw, confirm));
        assert(!manager.validateConfirmPass(pw, wrongConfirm));
        assert(manager.validateConfirmPass("",""));
    }
}