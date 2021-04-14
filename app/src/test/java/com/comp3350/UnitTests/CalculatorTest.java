package com.comp3350.UnitTests;

import com.comp3350.Logic.Calculator;
import com.comp3350.Object.User;

import junit.framework.AssertionFailedError;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test regarding the function of the calculations: BMI and BMR
 */
public class CalculatorTest {

    //User who only get
    User user0 = new User("Peter Parker", "PP@example.com",
            25, 170, "Male", 170, "123456");
    Calculator male = new Calculator("","", user0, 1.4); //26.74 & 1804.64 & 2526.49
    Calculator male_custom_weight = new Calculator("150", "", user0, 1.2); //23.59 & 1680.09 & 2016.11
    Calculator male_custom_height = new Calculator("", "185", user0, 1.7); //22.58 & 1879.64 & 3195.38
    Calculator male_custom_data = new Calculator("150", "185", user0, 1.4); //19.92 & 1755.09 & 2457.13

    User user1 = new User("Mary Jane", "MJ@example.com",
            22, 150, "Female", 160, "7890");
    Calculator female = new Calculator("", "", user1, 1.7); //26.63 & 1494.15 & 2540.05
    Calculator female_custom_weight = new Calculator("140", "", user1, 1.4); //24.86 & 1450.51 & 2030.71
    Calculator female_custom_height = new Calculator("", "165", user1, 1.2); //25.04 & 1503.15 & 1803.77
    Calculator female_custom_data = new Calculator("130", "155", user1, 1.7); //24.60 & 1397.87 & 2376.38


    @Test
    //test the calculation
    public void testBMICal() {
        male.calculate();
        male_custom_weight.calculate();
        male_custom_height.calculate();
        male_custom_data.calculate();
        female.calculate();
        female_custom_weight.calculate();
        female_custom_height.calculate();
        female_custom_data.calculate();

        //BMI - try with user data
        assertEquals(male.getBMI(), 26.74, 0.009);
        assertEquals(female.getBMI(), 26.63, 0.009);

        //BMI - try with custom weight
        assertEquals(male_custom_weight.getBMI(), 23.59, 0.009);
        assertEquals(female_custom_weight.getBMI(), 24.86, 0.009 );

        //BMI - try with custom height
        assertEquals(male_custom_height.getBMI(), 22.58, 0.009);
        assertEquals(female_custom_height.getBMI(), 25.04, 0.009 );

        //BMI - try with custom data
        assertEquals(male_custom_data.getBMI(), 19.92, 0.009);
        assertEquals(female_custom_data.getBMI(), 24.60, 0.009 );
    }

    @Test
    public void testMCCal() {
        male.calculate();
        male_custom_weight.calculate();
        male_custom_height.calculate();
        male_custom_data.calculate();
        female.calculate();
        female_custom_weight.calculate();
        female_custom_height.calculate();
        female_custom_data.calculate();

        //MC - try with user data
        assertEquals(male.getMC(), 2526.49, 0.009);
        assertEquals(female.getMC(), 2540.05, 0.009);

        //MC - try with custom weight
        assertEquals(male_custom_weight.getMC(), 2016.11, 0.009);
        assertEquals(female_custom_weight.getMC(), 2030.71, 0.009);

        //MC - try with custom height
        assertEquals(male_custom_height.getMC(), 3195.38, 0.009);
        assertEquals(female_custom_height.getMC(), 1803.77, 0.009);

        //MC - try with custom data
        assertEquals(male_custom_data.getMC(), 2457.13, 0.009);
        assertEquals(female_custom_data.getMC(), 2376.38, 0.009);

    }

}