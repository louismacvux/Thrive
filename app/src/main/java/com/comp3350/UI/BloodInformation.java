package com.comp3350.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.comp3350.Logic.BloodInformationManager;
import com.comp3350.Object.BloodSelfCheckDoc;
import com.comp3350.R;

public class BloodInformation extends AppCompatActivity {

    //When adding a new blood marker:
    //1. place the new id for new blood marks in the following arrays "generalInfoArray" and "symptomsArray"
    //2. add manager methods in "generalLocal" and symptomLocal" arrays placed in printGeneralInfo() and printSymptomInfo()
    //in the same order that will show up on the interface/UI
    private static final int[] generalInfoArray = {R.id.tshGeneralInfo, R.id.cortisolGeneralInfo,
            R.id.creatinineGeneralInfo, R.id.glucoseGeneralInfo, R.id.ironGeneralInfo, R.id.testGeneralInfo,
            R.id.estraGeneralInfo, R.id.generalMaleSugg, R.id.generalFemaleSugg};

    private static final int[] symptomsArray = {R.id.tsh_low_info, R.id.tsh_high_info,
            R.id.cortisol_low_info, R.id.cortisol_high_info, R.id.creatinine_low_info, R.id.creatinine_high_info,
            R.id.glucose_low_info, R.id.glucose_high_info, R.id.iron_low_info, R.id.iron_high_info,
            R.id.test_low_info, R.id.test_high_info, R.id.estra_low_info, R.id.estra_high_info};

    private TextView[] generalInfo = new TextView[generalInfoArray.length];
    private TextView[] symptoms = new TextView[symptomsArray.length];

    BloodInformationManager bloodInfoManager = new BloodInformationManager();
    BloodSelfCheckDoc selected_sugg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_information);

        //general info
        for (int i = 0; i < generalInfoArray.length; i ++)
            generalInfo[i] = (TextView) findViewById(generalInfoArray[i]);

        //symptoms
        for (int i = 0; i < symptomsArray.length; i ++)
            symptoms[i] = (TextView) findViewById(symptomsArray[i]);

        //Printing our all the information about the blood markers onto the screen
        printGeneralInfo(generalInfo);
        printSymptomInfo(symptoms);

    }//end onCreate

    @SuppressLint("SetTextI18n")
    public void printGeneralInfo(TextView[] generalInfo){
        String[] generalLocal = {bloodInfoManager.getTSHGeneral(), bloodInfoManager.getCortisolGeneral(),
                bloodInfoManager.getCreatinineGeneral(), bloodInfoManager.getGlucoseGeneral(),
                bloodInfoManager.getIronGeneral(), bloodInfoManager.getTestGeneral(),
                bloodInfoManager.getEstraGeneral(), getString(R.string.maleGeneral),
                getString(R.string.femaleGeneral)};

        for (int i = 0; i < generalInfo.length; i ++)
            generalInfo[i].setText(generalLocal[i]);

    }//end printGeneralInfo

    public void printSymptomInfo(TextView[] symptoms){
        String[] symptomLocal = {bloodInfoManager.getTSHLow(), bloodInfoManager.getTSHHigh(),
                bloodInfoManager.getCortisolLow(), bloodInfoManager.getCortisolHigh(), bloodInfoManager.getCreatinineLow(),
                bloodInfoManager.getCreatinineHigh(), bloodInfoManager.getGlucoseLow(), bloodInfoManager.getGlucoseHigh(),
                bloodInfoManager.getIronLow(), bloodInfoManager.getIronHigh(), bloodInfoManager.getTestLow(),
                bloodInfoManager.getTestHigh(), bloodInfoManager.getEstraLow(), bloodInfoManager.getEstraHigh()};

        for (int i = 0; i < symptoms.length; i ++)
            symptoms[i].setText(symptomLocal[i]);

    }//end printSymptomInfo

    //onclick
    public void tshLow(View v){ suggestions(1); }
    public void tshHigh(View v){ suggestions(2); }
    public void cortisolLow(View v){ suggestions(3); }
    public void cortisolHigh(View v){ suggestions(4); }
    public void creatinineLow(View v){ suggestions(5); }
    public void creatinineHigh(View v){ suggestions(6); }
    public void glucoseLow(View v){ suggestions(7); }
    public void glucoseHigh(View v){ suggestions(8); }
    public void ironLow(View v){ suggestions(9); }
    public void ironHigh(View v){ suggestions(10); }
    public void testLow(View v){ suggestions(11); }
    public void estraLow(View v){ suggestions(12); }
    public void estraHigh(View v){ suggestions(13); }
    public void maleSugg(View v){ suggestions(14); }
    public void femaleSugg(View v){ suggestions(15); }

    //tells the PDF viewer which one to show the user
    public void suggestions (int bloodMark){
        Intent pdfViewIntent = new Intent(BloodInformation.this, ViewPDF.class);
        Bundle bundle = new Bundle();

        switch(bloodMark){
            case 1 : selected_sugg = BloodSelfCheckDoc.TSHLow; break; //low TSH
            case 2 : selected_sugg = BloodSelfCheckDoc.TSHHigh; break; //high TSH
            case 3 : selected_sugg = BloodSelfCheckDoc.CortisolLow; break; //low cortisol
            case 4 : selected_sugg = BloodSelfCheckDoc.CortisolHigh; break; //high cortisol
            case 5 : selected_sugg = BloodSelfCheckDoc.CreatinineLow; break; //low creatinine
            case 6 : selected_sugg = BloodSelfCheckDoc.CreatinineHigh; break; //high creatinine
            case 7 : selected_sugg = BloodSelfCheckDoc.GlucoseLow; break; //low glucose
            case 8 : selected_sugg = BloodSelfCheckDoc.GlucoseHigh; break; //high glucose
            case 9 : selected_sugg = BloodSelfCheckDoc.IronLow; break; //low iron
            case 10 : selected_sugg = BloodSelfCheckDoc.IronHigh; break; //high iron
            case 11 : selected_sugg = BloodSelfCheckDoc.TestosteroneLow; break; //low testosterone
            case 12 : selected_sugg = BloodSelfCheckDoc.EstradiolLow; break; //low estradiol
            case 13 : selected_sugg = BloodSelfCheckDoc.EstradiolHigh; break; //high estradiol
            case 14 : selected_sugg = BloodSelfCheckDoc.MaleRecomm; break; //Male no symptoms
            case 15 : selected_sugg = BloodSelfCheckDoc.FemaleRecomm; break; //Female no symptoms
        }

        bundle.putString("fileName", selected_sugg.getFileName());
        pdfViewIntent.putExtras(bundle);
        startActivity(pdfViewIntent);
    }
}//end class