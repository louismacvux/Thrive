package com.comp3350.Database.BloodMarks;

import com.comp3350.R;
import com.comp3350.UI.MainActivity;

public class TSH implements IBlood {
    double tsh;

    public TSH(double tsh){
        this.tsh = tsh;
    }

    public TSH() { }

    @Override
    public String getGeneralInfo() {
        return MainActivity.getContext().getString(R.string.tshGeneral);
    }

    @Override
    public String getLowSymptoms() {
        return MainActivity.getContext().getString(R.string.tshLowSymptoms);
    }

    @Override
    public String getHighSymptoms() {
        return MainActivity.getContext().getString(R.string.tshHighSymptoms);
    }

    @Override
    public double getLevels() {
        return tsh;
    }
}//end class
