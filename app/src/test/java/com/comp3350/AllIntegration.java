package com.comp3350;

import com.comp3350.IntegrationTests.LoginTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
})

public class AllIntegration {
}
