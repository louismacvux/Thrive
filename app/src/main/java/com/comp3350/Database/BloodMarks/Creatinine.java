package com.comp3350.Database.BloodMarks;

import com.comp3350.R;
import com.comp3350.UI.MainActivity;

public class Creatinine implements IBlood{
    double creatinine;

    public Creatinine(double creatinine) {
        this.creatinine = creatinine;
    }

    public Creatinine() { }

    @Override
    public String getGeneralInfo() {
        return MainActivity.getContext().getString(R.string.creatinineGeneral);
    }

    @Override
    public String getLowSymptoms() {
        return MainActivity.getContext().getString(R.string.creatinineLowSymptoms);
    }

    @Override
    public String getHighSymptoms() {
        return MainActivity.getContext().getString(R.string.creatinineHighSymptoms);
    }

    @Override
    public double getLevels() {
        return creatinine;
    }

}
