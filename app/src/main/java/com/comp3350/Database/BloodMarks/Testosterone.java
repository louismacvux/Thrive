package com.comp3350.Database.BloodMarks;

public class Testosterone implements IBlood{
    @Override
    public String getGeneralInfo() {
        String result = "Testosterone is one of the most vital sexual hormones, specifically for males. " +
                "It regulates to a large context much of men's sexual function, mood stability, body composition and bone mass.";
        return result;
    }

    public String getLowSymptoms() {
        return "As a healthy male if you are having any symptoms of low testosterone levels including " +
                "lack of appetite, decrease in sexual libido, worse body fat distribution and depression. " +
                "If you find yourself with such symptoms, check out Thrives testosterone balancing strategies below.";
    }

}
