package com.comp3350.Database.BloodMarks;

public class Cortisol implements IBlood{
    float cortisol;

    public Cortisol(float cortisol){
        this.cortisol = cortisol;
    }

    public Cortisol() {}

    @Override
    public String getGeneralInfo() {
        String result = "Cortisol is the primary stress hormone in the human body.";
        return result;
    }

    public String getHighSymptoms() {
        return "If you are experiencing symptoms including muscle weakness, unmanageable fatigue, " +
                "difficulty concentrating or weight gain (bloating), there is a very high chance you " +
                "have stressed yourself out and have elevated levels of cortisol in your body.";
    }

}
