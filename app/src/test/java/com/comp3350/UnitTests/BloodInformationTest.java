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

    int num_test = 0;
    int failed_test = 0;

    @Test
    public void constructorTest(){ //constructor for each of the blood mark

        TSH tsh = new TSH(1.0);
        Cortisol cortisol  = new Cortisol(210);
        Creatinine creatinine = new Creatinine(1000);
        Glucose glucose = new Glucose(5.1);
        Iron iron = new Iron(40);
        Testosterone testosterone = new Testosterone(450);
        Estradiol estradiol = new Estradiol(360);

        num_test = 0;
        failed_test = 0;
        try {
            assert (tsh.getTsh() == 1.0);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (cortisol.getCortisol() == 210);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (creatinine.getCreatinine() == 1000);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert(glucose.getGlucose() == 5.1);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (iron.getIron() == 40);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (testosterone.getTestosterone() == 450);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (estradiol.getEstradiol() == 360);
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }

        System.out.println("*** CONSTRUCTOR TEST ***");
        System.out.println(num_test + " tests run, " + (num_test - failed_test) + " passed, "
                + failed_test + " failed.");
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

        num_test = 0;
        failed_test = 0;

        try {
            assertNotNull(newManager);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assertNotNull(tsh);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assertNotNull(cortisol);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assertNotNull(creatinine);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assertNotNull(glucose);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assertNotNull(iron);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assertNotNull(testosterone);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assertNotNull(estradiol);
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }

        try {
            assert (newManager.getTSHGeneral().equals(tsh.getGeneralInfo()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getCortisolGeneral().equals(cortisol.getGeneralInfo()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getCreatinineGeneral().equals(creatinine.getGeneralInfo()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getGlucoseGeneral().equals(glucose.getGeneralInfo()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getIronGeneral().equals(iron.getGeneralInfo()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getTestGeneral().equals(testosterone.getGeneralInfo()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getEstraGeneral().equals(estradiol.getGeneralInfo()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }

        try {
            assert (newManager.getTSHLow().equals(tsh.getLowSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getTSHHigh().equals(tsh.getHighSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getCortisolHigh().equals(cortisol.getHighSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getGlucoseLow().equals(glucose.getLowSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert(newManager.getGlucoseHigh().equals(glucose.getHighSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getIronLow().equals(iron.getLowSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getTestLow().equals(testosterone.getLowSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getEstraLow().equals(estradiol.getLowSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }
        try {
            assert (newManager.getEstraHigh().equals(estradiol.getHighSymptoms()));
            num_test++;
        } catch (AssertionFailedError e){
            failed_test++;
            System.out.println(e.getMessage());
        }

        System.out.println("*** GET GENERAL INFO ***");
        System.out.println(num_test + " tests run, " + (num_test - failed_test) + " passed, "
                + failed_test + " failed.");

    }
}