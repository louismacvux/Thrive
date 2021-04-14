package com.comp3350.UnitTests;

import com.comp3350.Database.BloodMarks.Cortisol;
import com.comp3350.Database.BloodMarks.Creatinine;
import com.comp3350.Database.BloodMarks.Estradiol;
import com.comp3350.Database.BloodMarks.Glucose;
import com.comp3350.Database.BloodMarks.Iron;
import com.comp3350.Database.BloodMarks.TSH;
import com.comp3350.Database.BloodMarks.Testosterone;
import com.comp3350.Logic.BloodInformationManager;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BloodInformationTest {

    @Test
    public void constructorTest(){ //constructor for each of the blood mark

        TSH tsh = new TSH(1.0);
        Cortisol cortisol  = new Cortisol(210);
        Creatinine creatinine = new Creatinine(1000);
        Glucose glucose = new Glucose(5.1);
        Iron iron = new Iron(40);
        Testosterone testosterone = new Testosterone(450);
        Estradiol estradiol = new Estradiol(360);

        assert (tsh.getLevels() == 1.0);
        assert (cortisol.getLevels() == 210);
        assert (creatinine.getLevels() == 1000);
        assert(glucose.getLevels() == 5.1);
        assert (iron.getLevels() == 40);
        assert (testosterone.getLevels() == 450);
        assert (estradiol.getLevels() == 360);

    }

    @Test
    public void getInfoTest() {
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

    }
}