package com.comp3350.Database.BloodMarks;

import com.comp3350.R;
import com.comp3350.UI.MainActivity;

public class Estradiol implements IBlood{
    double estradiol;

    public Estradiol(double estradiol){
        this.estradiol = estradiol;
    }

    public Estradiol () {}

    @Override
    public String getGeneralInfo() {
        return MainActivity.getContext().getString(R.string.estradiolGeneral);
    }

    @Override
    public String getLowSymptoms() {
        return MainActivity.getContext().getString(R.string.estradiolLowSymptoms);
    }

    @Override
    public String getHighSymptoms() {
        return MainActivity.getContext().getString(R.string.estradiolHighSymptoms);
    }

    @Override
    public double getLevels() {
        return estradiol;
    }
}
