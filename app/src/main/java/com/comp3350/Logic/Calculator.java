package com.comp3350.Logic;

import com.comp3350.Object.User;

public class Calculator {

    double maintenance_calories;
    String string_weight;
    String string_height;
    double activity_level;
    double bmi;
    User user;


    public Calculator(String string_weight, String string_height, User user, double activity_level){
        this.string_weight = string_weight;
        this.string_height = string_height;

        this.activity_level = activity_level;
        this.user = user;
    };

    public double calculateBMI(double weight, double height){
        double result;
        if (weight > 0 || height > 0){
            //convert weight from pounds to kilograms. 1kg = 2.2lb
            double convertedWeight = weight/2.2;
            //convert height from centimeters to meters. 1cm = 0.01m
            double convertedHeight = height/100;
            result = convertedWeight / (convertedHeight * convertedHeight);
        }else{
            result = -1;
        }

        return result;
    }

    public double calculateBMR(double weight, double height){
        double result;
        int gender = user.getGenderInt();
        int age = user.getAge();
        if (gender == 0) {
            //calculate BMR value of male
            result = 66 + (13.7 * weight / 2.2) + (5 * height) - (6.8 * age);
        }
        else if (gender == 1){
            //calculate BMR value for female
            result = 655 + (9.6 * weight/2.2) + (1.8 * height) - (4.7 * age);
        }
        else {
            //incorrect BMR due to incorrect gender
            result = -1;
        }
        return result;
    }

    public void calculate(){
        if (string_weight.equals("") && string_height.equals("")){ //calculate using personal data in profile
            maintenance_calories = activity_level * calculateBMR(user.getWeight(), user.getHeight());
            bmi = calculateBMI(user.getWeight(), user.getHeight());
        }
        else{ //calculate using new custom given data
            double weight = Double.parseDouble(string_weight);
            double height = Double.parseDouble(string_height);
            maintenance_calories = activity_level * calculateBMR(weight, height);
            bmi = calculateBMI(weight, height);
        }
    }

    //getter
    public double getWeightUsed(){
        double result;
        result = user.getWeight(); if (string_weight.equals(""));
        else result = Double.parseDouble(string_weight);
        return result;
    }

    public double getHeightUsed(){
        double result;
        result = user.getHeight(); if (string_height.equals(""));
        else result = Double.parseDouble(string_height);
        return result;
    }

    public double getBMI(){
        return bmi;
    }

    public double getMC() {
        return maintenance_calories;
    }

}
