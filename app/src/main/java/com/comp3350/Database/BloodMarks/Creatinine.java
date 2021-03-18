package com.comp3350.Database.BloodMarks;

public class Creatinine implements IBlood{
    @Override
    public String getGeneralInfo() {
        String result = "Creatinine is a byproduct of the bodies metabolic activities and can be used to accurately gauge ones kidney function.";
        return result;
    }

    public String getHighSymptoms() {
        return "If you are experiencing any of the following symptoms including urination issues, " +
                "muscle cramp, chest pain, increase in thirst or heavy fatigue. Check out Thrives high creatinine remedies.";
    }
}
