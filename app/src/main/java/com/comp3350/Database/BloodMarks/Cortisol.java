package com.comp3350.Database.BloodMarks;

import com.comp3350.R;
import com.comp3350.UI.MainActivity;

public class Cortisol implements IBlood{
    double cortisol;

    public Cortisol(double cortisol){
        this.cortisol = cortisol;
    }

    public Cortisol() {}

    @Override
    public String getGeneralInfo() {
        return MainActivity.getContext().getString(R.string.cortisolGeneral);
    }

    @Override
    public String getLowSymptoms() {
        return MainActivity.getContext().getString(R.string.cortisolLowSymptoms);
    }

    @Override
    public String getHighSymptoms() {
        return MainActivity.getContext().getString(R.string.cortisolHighSymptoms);
    }

    @Override
    public double getLevels() {
        return cortisol;
    }
}
