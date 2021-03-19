package com.comp3350.Database.BloodMarks;

public class Cortisol implements IBlood{
    float cortisol;

    public Cortisol(float cortisol){
        this.cortisol = cortisol;
    }

    public Cortisol() {}

    @Override
    public String getGeneralInfo() {
        return "ℹ️ Cortisol is the primary stress hormone in the human body.";
    }

    public String getHighSymptoms() {
        return "Experiencing symptoms including muscle weakness, unmanageable fatigue, " +
                "difficulty concentrating or weight gain (bloating)? There is a very high chance you " +
                "have stressed yourself out and have elevated levels of cortisol in your body. " +
                "Check out Thrive's cortisol balancing approach below.";
    }

}
