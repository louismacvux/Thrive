package com.comp3350;

import android.provider.ContactsContract;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Object.User;
import com.comp3350.UI.LoginActivity;
import com.comp3350.UI.WellnessCalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MealPlanTest {
    DatabaseHelper dbHelper;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        dbHelper = new DatabaseHelper();
        User testUser1 = new User("mealPlan", "mealPlan@email.com", 24, 138, "Male", 174, "password");
        dbHelper.addData(testUser1);
        Intents.init();
    }

    @After
    public void tearDown() {
        dbHelper.removeUser("mealPlan");
        Intents.release();
    }

    @Test
    public void getMealPlan() {
        //login
        closeSoftKeyboard();
        onView(withId(R.id.edittext_username)).perform(typeText("mealPlan"));
        closeSoftKeyboard();
        onView(withId(R.id.edittext_password)).perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.button_login)).perform(click());

        //test that user is using meal plan feature to get his desired meal plan
        onView(withId(R.id.cardview_mealPlan)).perform(click());
        //select vegetarian 3100 calories
        onView(withId(R.id.VegSpin)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("3100 calories"))).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Veg 3100.pdf")));

        //back and select vegetarian 2600 calories
        pressBack();
        onView(withId(R.id.VegSpin)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("2600 calories"))).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Veg 2600.pdf")));

        //back and select vegetarian 2200 calories
        pressBack();
        onView(withId(R.id.VegSpin)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("2200 calories"))).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Veg 2200.pdf")));

        //back and select vegetarian 1800 calories
        pressBack();
        onView(withId(R.id.VegSpin)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("1800 calories"))).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Veg 1800.pdf")));

        //back and select non vegetarian 3100 calories
        pressBack();
        onView(withId(R.id.NonVegSpin)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("3100 calories"))).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Non Veg 3100.pdf")));

        //back and select non vegetarian 2600 calories
        pressBack();
        onView(withId(R.id.NonVegSpin)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("2600 calories"))).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Non Veg 2600.pdf")));

        //back and select non vegetarian 2300 calories
        pressBack();
        onView(withId(R.id.NonVegSpin)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("2300 calories"))).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Non Veg 2300.pdf")));

        //back and select non vegetarian 1900 calories
        pressBack();
        onView(withId(R.id.NonVegSpin)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("1900 calories"))).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Non Veg 1900.pdf")));

        //back and press button of looking for more recipes
        pressBack();
        onView(withId(R.id.recipes)).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("recipes.pdf")));

        //back and press button of not sure calories
        //go to wellness calculator feature
        pressBack();
        onView(withId(R.id.BMI)).perform(click());
        //check current activity on WellnessCalculator
        intended(hasComponent(WellnessCalculator.class.getName()));
    }
}
