package com.comp3350;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
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
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BloodInformationTest {
    DatabaseHelper dbHelper;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
        DatabaseServices.setDB();
        dbHelper = new DatabaseHelper();
        User testUser1 = new User("maleUser", "maleUser@email.com", 25, 170.5, "Male", 178, "password");
        dbHelper.addData(testUser1);
    }

    @After
    public void tearDown() {
        dbHelper.removeUser("maleUser");
    }

    @Test
    public void testSuggestionDocs() {
        //login
        closeSoftKeyboard();
        onView(withId(R.id.edittext_username)).perform(typeText("maleUser"));
        closeSoftKeyboard();
        onView(withId(R.id.edittext_password)).perform(typeText("password"));
        closeSoftKeyboard();
        onView(withId(R.id.button_login)).perform(click());

        //get to the blood optimizer feature
        onView(withId(R.id.cardview_bloodOptimizer)).perform(click());

        //check all the pdf files from top to bottom
        onView(withId(R.id.tsh_low_sugg)).perform(scrollTo(), click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("TSH(Low).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.tsh_high_sugg)).perform(scrollTo(), click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("TSH(High).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.cortisol_low_sugg)).perform(scrollTo(), click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Cortisol(Low).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.cortisol_high_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Cortisol(High).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.creatinine_low_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Creatinine(Low).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.creatinine_high_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Creatinine(High).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.glucose_low_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Glucose(Low).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.glucose_high_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Glucose(High).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.iron_low_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Iron(Low).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.iron_high_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Iron(High).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.test_low_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Testosterone(Low).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.estra_low_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Estradiol(Low).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.estra_high_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("Estradiol(High).pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.general_m_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("GeneralMaleRecom.pdf")));

        //back and select next file
        pressBack();
        onView(withId(R.id.general_f_sugg)).perform(scrollTo(),click());
        onView(withId(R.id.pdfView)).check(matches(isCompletelyDisplayed()));
        onView(withId(R.id.pdf_fileName)).check(matches(withText("GeneralFemaleRecom.pdf")));
    }
}
