package com.comp3350.Database.BloodMarks;

public class Creatinine implements IBlood{
    float creatinine;

    public Creatinine(float creatinine) {
        this.creatinine = creatinine;
    }

    public Creatinine() { }

    @Override
    public String getGeneralInfo() {
        return "ℹ️ Creatinine is a byproduct of the bodies metabolic activities and can be used to accurately gauge ones kidney function.";
    }

    public String getHighSymptoms() {
        return "Experiencing any of the following symptoms including urination issues, " +
                "muscle cramp, chest pain, increase in thirst or heavy fatigue? Check out Thrive's high creatinine remedies.";
    }
}
