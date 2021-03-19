package com.comp3350;

import com.comp3350.Logic.LoginManager;
import com.comp3350.UnitTests.BloodInformationTest;
import com.comp3350.UnitTests.RegisterManagerTest;
import com.comp3350.UnitTests.UserTest;
import com.comp3350.UnitTests.WellnessCalculatorTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserTest.class,
        BloodInformationTest.class,
        RegisterManagerTest.class,
        WellnessCalculatorTest.class,
})

public class AutomatedTest {
}
