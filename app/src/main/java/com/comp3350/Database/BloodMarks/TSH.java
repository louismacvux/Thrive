package com.comp3350.Database.BloodMarks;

public class TSH implements IBlood {
    float tsh;

    public TSH(float tsh){
        this.tsh = tsh;
    }

    public TSH() { }

    @Override
    public String getGeneralInfo() {
        String result = "TSH, also referred to as Thyroid-Stimulating Hormone, is a pituitary hormone that " +
                "stimulates the thyroid gland, which is responsible for the metabolism of almost every tissue is in the body.";
        return result;
    }

//    @Override
    public String getLowSymptoms() {
        return "If you are experiencing any symptoms including increased sensitivity to cold, weight " +
                "gain, heavier than normal or irregular menstrual periods(women) or fatigue, " +
                "check out Thrives low TSH balancing strategies.";
    }

//    @Override
    public String getHighSymptoms() {
        return "If you are experiencing a slow heart rate, thinning of hair, fertility issues or swelling " +
                "of the face and neck, check out Thrives high TSH balancing strategies.";
    }
}//end class
