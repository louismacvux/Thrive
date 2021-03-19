package com.comp3350.Database.BloodMarks;

public class Estradiol implements IBlood{
    double estradiol;

    public Estradiol(double estradiol){
        this.estradiol = estradiol;
    }

    public Estradiol () {}

    @Override
    public String getGeneralInfo() {
        return "ℹ️ Estradiol, also referred to as estrogen, is one of the most vital sexual " +
                "hormone for women. It regulates to a large context much of women's sexual function " +
                "/ development, metabolism of important metabolites, insulin sensitivity and body composition. ";
    }

    public String getLowSymptoms() {
        return "Are having irregular periods, hot flashes, mood swings, " +
                "fatigue or depression? Check out Thrive's low estrogen balancing approach below.";
    }

    public String getHighSymptoms() {
        return "Experiencing symptoms such as bloating, cold hands and feet, low " +
                "sex drive and hair loss? Check out Thrives high estrogen balancing approach below.";
    }

    public double getEstradiol() {
        return estradiol;
    }
}
