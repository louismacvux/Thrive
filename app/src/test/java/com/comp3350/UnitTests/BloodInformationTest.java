package com.comp3350.UnitTests;

import com.comp3350.Database.BloodMarks.Cortisol;
import com.comp3350.Database.BloodMarks.Creatinine;
import com.comp3350.Database.BloodMarks.Estradiol;
import com.comp3350.Database.BloodMarks.Glucose;
import com.comp3350.Database.BloodMarks.Iron;
import com.comp3350.Database.BloodMarks.TSH;
import com.comp3350.Database.BloodMarks.Testosterone;
import com.comp3350.Logic.BloodInformationManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BloodInformationTest {

    @Test
    public void constructorTest(){ //constructor for each of the blood mark
        TSH tsh = new TSH();
        Cortisol cortisol  = new Cortisol();
        Creatinine creatinine = new Creatinine();
        Glucose glucose = new Glucose();
        Iron iron = new Iron();
        Testosterone testosterone = new Testosterone();
        Estradiol estradiol = new Estradiol();
    }

    @Test
    public void getGeneralInfoTest() {
        BloodInformationManager newManager = new BloodInformationManager();

        TSH tsh = new TSH();
        Cortisol cortisol  = new Cortisol();
        Creatinine creatinine = new Creatinine();
        Glucose glucose = new Glucose();
        Iron iron = new Iron();
        Testosterone testosterone = new Testosterone();
        Estradiol estradiol = new Estradiol();

        assertNotNull(newManager);
        assertNotNull(tsh);
        assertNotNull(cortisol);
        assertNotNull(creatinine);
        assertNotNull(glucose);
        assertNotNull(iron);
        assertNotNull(testosterone);
        assertNotNull(estradiol);

        assert(newManager.getTSHGeneral().equals(tsh.getGeneralInfo()));
        assert(newManager.getCortisolGeneral().equals(cortisol.getGeneralInfo()));
        assert(newManager.getCreatinineGeneral().equals(creatinine.getGeneralInfo()));
        assert(newManager.getGlucoseGeneral().equals(glucose.getGeneralInfo()));
        assert(newManager.getIronGeneral().equals(iron.getGeneralInfo()));
        assert(newManager.getTestGeneral().equals(testosterone.getGeneralInfo()));
        assert(newManager.getEstraGeneral().equals(estradiol.getGeneralInfo()));

        assert(newManager.getTSHLow().equals(tsh.getLowSymptoms()));
        assert(newManager.getTSHHigh().equals(tsh.getHighSymptoms()));
        assert(newManager.getCortisolHigh().equals(cortisol.getHighSymptoms()));
        assert(newManager.getCreatinineHigh().equals(creatinine.getHighSymptoms()));
        assert(newManager.getGlucoseLow().equals(glucose.getLowSymptoms()));
        assert(newManager.getGlucoseHigh().equals(glucose.getHighSymptoms()));
        assert(newManager.getIronLow().equals(iron.getLowSymptoms()));
        assert(newManager.getTestLow().equals(testosterone.getLowSymptoms()));
        assert(newManager.getEstraLow().equals(estradiol.getLowSymptoms()));
        assert(newManager.getEstraHigh().equals(estradiol.getHighSymptoms()));
    }
}