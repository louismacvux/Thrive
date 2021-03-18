package com.comp3350.Database.BloodMarks;

public class Estradiol implements IBlood{
    float estradiol;

    public Estradiol(float estradiol){
        this.estradiol = estradiol;
    }

    public Estradiol () {}

    @Override
    public String getGeneralInfo() {
        String result = "Estradiol, also referred to as estrogen, is one of the most vital sexual " +
                "hormone for women. It regulates to a large context much of women's sexual function " +
                "/ development, metabolism of important metabolites, insulin sensitivity and body composition. ";
        return result;
    }

//    @Override
    public String getLowSymptoms() {
        return "As a healthy women if you are having irregular periods, hot flashes, mood swings, " +
                "fatigue or depression, check out Thrives low estrogen balancing approach below.";
    }

//    @Override
    public String getHighSymptoms() {
        return "On the other hand experiencing symptoms such as bloating, cold hands and feet, low " +
                "sex drive and hair loss can point towards high estrogen, check out Thrives high estrogen balancing approach below.";
    }
}
