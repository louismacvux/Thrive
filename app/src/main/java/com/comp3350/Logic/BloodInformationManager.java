package com.comp3350.Logic;

import com.comp3350.Database.BloodMarks.Cortisol;
import com.comp3350.Database.BloodMarks.Creatinine;
import com.comp3350.Database.BloodMarks.Estradiol;
import com.comp3350.Database.BloodMarks.Glucose;
import com.comp3350.Database.BloodMarks.Iron;
import com.comp3350.Database.BloodMarks.TSH;
import com.comp3350.Database.BloodMarks.Testosterone;

public class BloodInformationManager {

    //sends data from the data layer to the UI
    public BloodInformationManager() { }

    TSH tsh = new TSH();
    Cortisol cortisol  = new Cortisol();
    Creatinine creatinine = new Creatinine();
    Glucose glucose = new Glucose();
    Iron iron = new Iron();
    Testosterone testosterone = new Testosterone();
    Estradiol estradiol = new Estradiol();

    //general information
    public String getTSHGeneral(){ return tsh.getGeneralInfo(); }
    public String getCortisolGeneral() { return cortisol.getGeneralInfo(); }
    public String getCreatinineGeneral() { return creatinine.getGeneralInfo(); }
    public String getGlucoseGeneral() { return glucose.getGeneralInfo(); }
    public String getIronGeneral() { return iron.getGeneralInfo(); }
    public String getTestGeneral() { return testosterone.getGeneralInfo(); }
    public String getEstraGeneral() { return estradiol.getGeneralInfo(); }

    //symptoms
    public String getTSHLow() { return tsh.getLowSymptoms(); }
    public String getTSHHigh() { return tsh.getHighSymptoms(); }
    public String getCortisolHigh() {return cortisol.getHighSymptoms(); }
    public String getCreatinineHigh() { return creatinine.getHighSymptoms(); }
    public String getGlucoseLow() { return glucose.getLowSymptoms(); }
    public String getGlucoseHigh() { return glucose.getHighSymptoms(); }
    public String getIronLow() { return iron.getLowSymptoms(); }
    public String getTestLow() { return testosterone.getLowSymptoms(); }
    public String getEstraLow() { return estradiol.getLowSymptoms(); }
    public String getEstraHigh() { return estradiol.getHighSymptoms(); }
}//end class
