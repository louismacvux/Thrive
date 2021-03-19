package com.comp3350.Database.BloodMarks;

public class Glucose implements IBlood{
    float glucose;

    public Glucose(float glucose){
        this.glucose = glucose;
    }

    public Glucose() {}

    @Override
    public String getGeneralInfo() {
        return "ℹ️ Blood glucose is a sugar that the bloodstream carries to all cells in the " +
                "body to supply energy. These levels can accurately indicate any chance of diabetes or increased insulin sensitivity. ";
    }

    public String getLowSymptoms() {
        return "Experiencing extreme sweating, irritability, increase in hunger, " +
                "nervousness, weakness and anxiety? A simple fix is to increase your carbohydrate " +
                "intake in any form, whether it be through candy or actual food. This will help your blood glucose stabilize.";
    }

    public String getHighSymptoms() {
        return "Experiencing any of the following symptoms including a very dry mouth, " +
                "extreme thirst, light headedness, a fast heart beat followed with a weak pulse? " +
                "Check out Thrive's high blood glucose recommendation. ";
    }
}
