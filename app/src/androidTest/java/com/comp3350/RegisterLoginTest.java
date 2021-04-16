package com.comp3350;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Object.User;
import com.comp3350.UI.LoginActivity;
import com.comp3350.UI.MainActivity;
import com.comp3350.UI.WellnessCalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterLoginTest {
    DatabaseHelper dbHelper;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        dbHelper = new DatabaseHelper();
        Intents.init();
    }

    @After
    public void tearDown() {
        dbHelper.removeUser("register");
        Intents.release();
    }

    @Test
    public void registerAndLogin() {
        //go to register page
        closeSoftKeyboard();
        onView(withId(R.id.button_register)).perform(click());

        //register process
        onView(withId(R.id.edittext_username)).perform(typeText("register"));
        closeSoftKeyboard();
        onView(withId(R.id.edittext_useremail)).perform(typeText("register@email.com"));
        closeSoftKeyboard();
        onView(withId(R.id.edittext_password)).perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.edittext_confrim_password)).perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.radioBtn_male)).perform(click());
        onView(withId(R.id.radioBtn_male)).check(matches(isChecked()));
        onView(withId(R.id.edittext_age)).perform(typeText("21"));
        closeSoftKeyboard();
        onView(withId(R.id.edittext_weight)).perform(typeText("138.56"));
        closeSoftKeyboard();
        onView(withId(R.id.edittext_height)).perform(typeText("174.5"));
        closeSoftKeyboard();
        onView(withId(R.id.button_done_register)).perform(click());

        //login
        onView(withId(R.id.edittext_username)).perform(typeText("register"));
        closeSoftKeyboard();
        onView(withId(R.id.edittext_password)).perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.button_login)).perform(click());
        //check current activity on MainActivity
        intended(hasComponent(MainActivity.class.getName()));
    }
}
