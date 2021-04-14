package com.comp3350.Database.BloodMarks;

import com.comp3350.R;
import com.comp3350.UI.MainActivity;

public class Testosterone implements IBlood{
    double testosterone;

    public Testosterone(double testosterone) {
        this.testosterone = testosterone;
    }

    public Testosterone() {
    }

    @Override
    public String getGeneralInfo() {
        return MainActivity.getContext().getString(R.string.testGeneral);
    }

    @Override
    public String getLowSymptoms() {
        return MainActivity.getContext().getString(R.string.testLowSymptoms);
    }

    @Override
    public String getHighSymptoms(){
        return MainActivity.getContext().getString(R.string.testHighSymptoms);
    }

    @Override
    public double getLevels() {
        return testosterone;
    }
}
