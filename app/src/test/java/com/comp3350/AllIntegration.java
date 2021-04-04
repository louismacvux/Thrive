package com.comp3350;

import com.comp3350.IntegrationTests.LoginTest;
import com.comp3350.IntegrationTests.RegisterTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
        RegisterTest.class,
})

public class AllIntegration {
}
