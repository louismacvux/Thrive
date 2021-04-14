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
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class WorkoutSuggestionTest {
    DatabaseHelper dbHelper;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        dbHelper = new DatabaseHelper();
        User testUser1 = new User("femaleUser", "femaleUser@email.com", 22, 115, "Female", 164, "password");
        dbHelper.addData(testUser1);
    }

    @After
    public void tearDown() {
        dbHelper.removeUser("femaleUser");
    }

    @Test
    public void getWorkoutSuggestion() {
        //login
        onView(withId(R.id.edittext_username)).perform(typeText("femaleUser"));
        onView(withId(R.id.edittext_password)).perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.button_login)).perform(click());

        //test that user is using wellness calculator feature to get his wellness number
        onView(withId(R.id.cardview_workoutPlan)).perform(click());
        //select Tone up
        onView(withId(R.id.spinner_workout)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Tone up"))).perform(click());
        onView(withId(R.id.button_next)).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Female_ToneUp_Doc.pdf")));

        //back and select Build muscle
        pressBack();
        onView(withId(R.id.spinner_workout)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Build muscle"))).perform(click());
        onView(withId(R.id.button_next)).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Female_BuildMuscle_Doc.pdf")));

        //back and select Loose fat
        pressBack();
        onView(withId(R.id.spinner_workout)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Loose fat"))).perform(click());
        onView(withId(R.id.button_next)).perform(click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Female_FatLoss_Doc.pdf")));
    }
}
