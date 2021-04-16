package com.comp3350.UnitTests;

import com.comp3350.Logic.Calculator;
import com.comp3350.Object.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test regarding the function of the calculator
 */
@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
    private User user;
    private Calculator calculator;

    @Before
    public void setUp() {
        user = mock(User.class);
        calculator = new Calculator("", "", user, 1.2);
    }

    @Test
    //test the calculation
    public void testCalculateBMI() {
        double expected1 = calculator.calculateBMI(145, 178);
        double expected2 = calculator.calculateBMI(122.5, 167.5);
        double expected3 = calculator.calculateBMI(130,0);
        double expected4 = calculator.calculateBMI(0,170);
        double expected5 = calculator.calculateBMI(0,0);

        assertEquals(expected1, 20.8020, 0.009);
        assertEquals(expected2, 19.8465, 0.009);
        assertEquals(expected3, -1,0.009);
        assertEquals(expected4, -1,0.009);
        assertEquals(expected5, -1,0.009);
    }

    @Test
    public void testCalculateBMR() {
        when(user.getGenderInt()).thenReturn(0).thenReturn(1).thenReturn(2);
        when(user.getAge()).thenReturn(20).thenReturn(22).thenReturn(18);
        double expected1 = calculator.calculateBMR(144, 169);
        double expected2 = calculator.calculateBMR(118, 162);
        double expected3 = calculator.calculateBMR(152, 183);

        assertEquals(expected1, 1671.7273, 0.009);
        assertEquals(expected2, 1358.1091, 0.009);
        assertEquals(expected3, -1, 0.009);
    }

    @Test
    public void testGetWeightUsed() {
        when(user.getWeight()).thenReturn(148.00);
        double expected1 = calculator.getWeightUsed();
        assertEquals(expected1, 148, 0.009);

        calculator = new Calculator(".", "", user, 1.2);
        when(user.getWeight()).thenReturn(149.00);
        double expected2 = calculator.getWeightUsed();
        assertEquals(expected2, 149, 0.009);

        calculator = new Calculator("000000", "", user, 1.2);
        when(user.getWeight()).thenReturn(150.00);
        double expected3 = calculator.getWeightUsed();
        assertEquals(expected3, 150, 0.009);

        calculator = new Calculator("125", "", user, 1.2);
        when(user.getWeight()).thenReturn(151.00);
        double expected4 = calculator.getWeightUsed();
        assertEquals(expected4, 125, 0.009);
    }

    @Test
    public void testGetHeightUsed() {
        when(user.getHeight()).thenReturn(170.00);
        double expected1 = calculator.getHeightUsed();
        assertEquals(expected1, 170, 0.009);

        calculator = new Calculator("", ".", user, 1.2);
        when(user.getHeight()).thenReturn(171.00);
        double expected2 = calculator.getHeightUsed();
        assertEquals(expected2, 171, 0.009);

        calculator = new Calculator("", "000000", user, 1.2);
        when(user.getHeight()).thenReturn(172.00);
        double expected3 = calculator.getHeightUsed();
        assertEquals(expected3, 172, 0.009);

        calculator = new Calculator("", "182", user, 1.2);
        when(user.getHeight()).thenReturn(173.00);
        double expected4 = calculator.getHeightUsed();
        assertEquals(expected4, 182, 0.009);
    }
}