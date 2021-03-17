package com.example.comp3350;

import com.comp3350.Logic.Calculator;
import com.comp3350.Object.User;

import junit.framework.AssertionFailedError;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test regarding the function of the calculations: BMI and BMR
 *
 *
 */
public class WellnessCalculatorTest {

    int num_tested;
    int failed_test;

    //User who only get
    User user0 = new User(1, "Peter Parker", "PP@example.com",
            25, 170, "male", 170, "123456");
    Calculator calculator0 = new Calculator("","",user0, 1.4);

    User user1 = new User(2, "Mary Jane", "MJ@example.com",
            22, 150, "female", 160, "7890"); //2540.05 & 26.63
    Calculator calculator1 = new Calculator("", "", user1, 1.7);


    @Test
    //test the calculation
    public void testBMICal() throws Exception {
        //BMI - try with user data
        try {
            num_tested++;
            assertEquals(calculator0.calculateBMI(user0.getWeight(), user0.getHeight()), 26.74, 0.009);
        } catch (AssertionFailedError e) {
            failed_test++;
            System.out.println(e.getMessage());
        }

        try {
            num_tested++;
            assertEquals(calculator1.calculateBMI(user1.getWeight(), user1.getHeight()), 26.63, 0.009);
        }
        catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }

        //BMI - try with input data
        try {
            num_tested++;
            assertEquals(calculator0.calculateBMI(170, 170), 26.74, 0.009);
        } catch (AssertionFailedError e) {
            failed_test++;
            System.out.println(e.getMessage());
        }

        try {
            num_tested++;
            assertEquals(calculator1.calculateBMI(150, 160), 26.63, 0.009 );
        }
        catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testBMRCal() throws Exception{
        //BMR - try with user data
        try{
            num_tested++;
            assertEquals(calculator0.calculateBMR(user0.getWeight(), user0.getHeight()), 2165.56, 0.009);
        }
        catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }

        try{
            num_tested++;
            assertEquals(calculator1.calculateBMR(user1.getWeight(), user1.getHeight()), 2540.05, 0.009);
        }
        catch (AssertionFailedError e) {
            failed_test++;
            System.out.println(e.getMessage());
        }

        //BMR - try with input data
        try{
            num_tested++;
            assertEquals(calculator0.calculateBMR(170,170), 2165.56, 0.009);
        }
        catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }

        try{
            num_tested++;
            assertEquals(calculator1.calculateBMR(150, 160), 2540.05, 0.009);
        }
        catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
    }
}