package com.comp3350.Database.BloodMarks;

import com.comp3350.R;
import com.comp3350.UI.MainActivity;

public class Iron implements IBlood{
    double iron;

    public Iron(double iron){
        this.iron = iron;
    }

    public Iron() {}

    @Override
    public String getGeneralInfo() {
        return MainActivity.getContext().getString(R.string.ironGeneral);
    }

    @Override
    public String getLowSymptoms() {
        return MainActivity.getContext().getString(R.string.ironLowSymptoms);
    }

    @Override
    public String getHighSymptoms(){
        return MainActivity.getContext().getString(R.string.ironHighSymptoms);
    }

    @Override
    public double getLevels() {
        return iron;
    }
}
