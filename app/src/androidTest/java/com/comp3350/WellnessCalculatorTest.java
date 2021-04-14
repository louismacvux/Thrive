package com.comp3350;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Object.User;
import com.comp3350.UI.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class WellnessCalculatorTest {
    DatabaseHelper dbHelper;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        dbHelper = new DatabaseHelper();
        User testUser1 = new User("testUser", "testUser@email.com", 20, 145.5, "Male", 177.5, "password");
        dbHelper.addData(testUser1);
    }

    @After
    public void tearDown() {
        dbHelper.removeUser("testUser");
    }

    @Test
    public void getWellnessNumber() {
        //login
        onView(withId(R.id.edittext_username)).perform(typeText("testUser"));
        onView(withId(R.id.edittext_password)).perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.button_login)).perform(click());

        //test that user is using wellness calculator feature to get his wellness number
        onView(withId(R.id.cardview_bmi)).perform(click());
        //no custom data and select barely active
        closeSoftKeyboard();
        onView(withId(R.id.button_calculate)).perform(click());
        onView(withId(R.id.mc_result)).check(matches(withText("2068.28 Calories/day are needed to maintain your current body composition.")));
        onView(withId(R.id.weight_result)).check(matches(withText("145.50")));
        onView(withId(R.id.height_result)).check(matches(withText("177.50")));
        onView(withId(R.id.bmi_result)).check(matches(withText("20.99")));
        onView(withId(R.id.health_range)).check(matches(withText("Your weight is normal.")));

        //back and select highly active
        pressBack();
        onView(withId(R.id.spinner_activity_level)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Highly active"))).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.button_calculate)).perform(click());
        onView(withId(R.id.mc_result)).check(matches(withText("2930.07 Calories/day are needed to maintain your current body composition.")));
        onView(withId(R.id.weight_result)).check(matches(withText("145.50")));
        onView(withId(R.id.height_result)).check(matches(withText("177.50")));
        onView(withId(R.id.bmi_result)).check(matches(withText("20.99")));
        onView(withId(R.id.health_range)).check(matches(withText("Your weight is normal.")));

        //back and custom weight and select active
        pressBack();
        onView(withId(R.id.spinner_activity_level)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Active"))).perform(click());
        onView(withId(R.id.edittext_new_weight)).perform(typeText("142.65"));
        closeSoftKeyboard();
        onView(withId(R.id.button_calculate)).perform(click());
        onView(withId(R.id.mc_result)).check(matches(withText("2388.15 Calories/day are needed to maintain your current body composition.")));
        onView(withId(R.id.weight_result)).check(matches(withText("142.65")));
        onView(withId(R.id.height_result)).check(matches(withText("177.50")));
        onView(withId(R.id.bmi_result)).check(matches(withText("20.58")));
        onView(withId(R.id.health_range)).check(matches(withText("Your weight is normal.")));

        //back and delete custom weight and custom height
        pressBack();
        onView(withId(R.id.edittext_new_weight)).perform(clearText());
        onView(withId(R.id.edittext_new_height)).perform(typeText("178.5"));
        closeSoftKeyboard();
        onView(withId(R.id.button_calculate)).perform(click());
        onView(withId(R.id.mc_result)).check(matches(withText("2420.00 Calories/day are needed to maintain your current body composition.")));
        onView(withId(R.id.weight_result)).check(matches(withText("145.50")));
        onView(withId(R.id.height_result)).check(matches(withText("178.50")));
        onView(withId(R.id.bmi_result)).check(matches(withText("20.76")));
        onView(withId(R.id.health_range)).check(matches(withText("Your weight is normal.")));

        //back and custom weight again and keep custom height
        pressBack();
        onView(withId(R.id.edittext_new_weight)).perform(typeText("150.25"));
        closeSoftKeyboard();
        onView(withId(R.id.button_calculate)).perform(click());
        onView(withId(R.id.mc_result)).check(matches(withText("2461.41 Calories/day are needed to maintain your current body composition.")));
        onView(withId(R.id.weight_result)).check(matches(withText("150.25")));
        onView(withId(R.id.height_result)).check(matches(withText("178.50")));
        onView(withId(R.id.bmi_result)).check(matches(withText("21.43")));
        onView(withId(R.id.health_range)).check(matches(withText("Your weight is normal.")));
    }
}
