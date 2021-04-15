package com.comp3350;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MealPlanTest.class,
        WellnessCalculatorTest.class,
        WorkoutSuggestionTest.class,
        BloodInformationTest.class

})

public class AllAcceptanceTests {
}
