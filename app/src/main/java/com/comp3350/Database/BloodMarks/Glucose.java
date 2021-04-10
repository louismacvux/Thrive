package com.comp3350.Database.BloodMarks;

import com.comp3350.R;
import com.comp3350.UI.MainActivity;

public class Glucose implements IBlood{
    double glucose;

    public Glucose(double glucose){
        this.glucose = glucose;
    }

    public Glucose() {}

    @Override
    public String getGeneralInfo() {
        return MainActivity.getContext().getString(R.string.glucoseGeneral);
    }

    @Override
    public String getLowSymptoms() {
        return MainActivity.getContext().getString(R.string.glucoseLowSymptoms);
    }

    @Override
    public String getHighSymptoms() {
        return MainActivity.getContext().getString(R.string.glucoseHighSymptoms);
    }

    @Override
    public double getLevels() {
        return glucose;
    }
}
