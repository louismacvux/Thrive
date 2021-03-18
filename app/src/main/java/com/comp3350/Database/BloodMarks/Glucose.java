package com.comp3350.Database.BloodMarks;

public class Glucose implements IBlood{
    float glucose;

    public Glucose(float glucose){
        this.glucose = glucose;
    }

    public Glucose() {}

    @Override
    public String getGeneralInfo() {
        String result = "Blood glucose is a sugar that the bloodstream carries to all cells in the " +
                "body to supply energy. These levels can accurately indicate any chance of diabetes or increased insulin sensitivity. ";
        return result;
    }

//    @Override
    public String getLowSymptoms() {
        return "On the other hand if you experience extreme sweating, irritability, increase in hunger, " +
                "nervousness, weakness and anxiety, a simple fix is to increase your carbohydrate " +
                "intake in any form, whether it be through candy or actual food. This will help your blood glucose stabilize.";
    }

//    @Override
    public String getHighSymptoms() {
        return "If you are experiencing any of the following symptoms including a very dry mouth, " +
                "extreme thirst, light headedness, a fast heart beat followed with a weak pulse, " +
                "read Thrives high blood glucose recommendation's. ";
    }
}
