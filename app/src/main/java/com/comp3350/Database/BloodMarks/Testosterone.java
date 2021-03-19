package com.comp3350.Database.BloodMarks;

public class Testosterone implements IBlood{
    @Override
    public String getGeneralInfo() {
        return "ℹ️ Testosterone is one of the most vital sexual hormones, specifically for males. " +
                "It regulates to a large context much of men's sexual function, mood stability, body composition and bone mass.";
    }

    public String getLowSymptoms() {
        return "Having symptoms such as lack of appetite, decrease in sexual libido, worse body fat distribution and depression? " +
                "Check out Thrives testosterone balancing strategies below.";
    }

}
