package com.comp3350.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.comp3350.Logic.BloodInformationManager;
import com.comp3350.Object.BloodSelfCheckDoc;
import com.comp3350.R;

public class BloodInformation extends AppCompatActivity {
    
    TextView tshGeneralInfo, cortisolGeneralInfo, creatinineGeneralInfo, glucoseGeneralInfo,
             ironGeneralInfo, testGeneralInfo, estraGeneralInfo;
    TextView generalMaleSugg, generalFemaleSugg;

    TextView tshLow, tshHigh, cortisolLow, cortisolHigh, creatinineLow, creatinineHigh, glucoseLow,
             glucoseHigh, ironLow, ironHigh, testLow, testHigh, estraLow, estraHigh;

    Button tshLowBtn, tshHighBtn, cortisolLowBtn, cortisolHighBtn, creatinineLowBtn, creatinineHighBtn,
           glucoseLowBtn, glucoseHighBtn, ironLowBtn, ironHighBtn,
           testLowBtn, estraLowBtn, estraHighBtn, generalMBtn, generalFBtn;

    BloodInformationManager bloodInfoManager = new BloodInformationManager();

    BloodSelfCheckDoc selected_sugg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_information);

        //general info
        tshGeneralInfo = (TextView) findViewById(R.id.tshGeneralInfo);
        cortisolGeneralInfo = (TextView) findViewById(R.id.cortisolGeneralInfo);
        creatinineGeneralInfo = (TextView) findViewById(R.id.creatinineGeneralInfo);
        glucoseGeneralInfo = (TextView) findViewById(R.id.glucoseGeneralInfo);
        ironGeneralInfo = (TextView) findViewById(R.id.ironGeneralInfo);
        testGeneralInfo = (TextView) findViewById(R.id.testGeneralInfo);
        estraGeneralInfo = (TextView) findViewById(R.id.estraGeneralInfo);
        generalMaleSugg = (TextView) findViewById(R.id.generalMaleSugg);
        generalFemaleSugg = (TextView) findViewById(R.id.generalFemaleSugg);

        //symptoms
        tshLow = (TextView) findViewById(R.id.tsh_low_info);
        tshHigh = (TextView) findViewById(R.id.tsh_high_info);
        cortisolLow = (TextView) findViewById(R.id.cortisol_low_info);
        cortisolHigh = (TextView) findViewById(R.id.cortisol_high_info);
        creatinineLow = (TextView) findViewById(R.id.creatinine_low_info);
        creatinineHigh = (TextView) findViewById(R.id.creatinine_high_info);
        glucoseLow = (TextView) findViewById(R.id.glucose_low_info);
        glucoseHigh = (TextView) findViewById(R.id.glucose_high_info);
        ironLow = (TextView) findViewById(R.id.iron_low_info);
        ironHigh = (TextView) findViewById(R.id.iron_high_info);
        testLow = (TextView) findViewById(R.id.test_low_info);
        testHigh = (TextView) findViewById(R.id.test_high_info);
        estraLow = (TextView) findViewById(R.id.estra_low_info);
        estraHigh = (TextView) findViewById(R.id.estra_high_info);

        //suggestion buttons
        tshLowBtn = (Button) findViewById(R.id.tsh_low_sugg); //bloodMark = 1
        tshHighBtn = (Button) findViewById(R.id.tsh_high_sugg); //bloodMark = 2
        cortisolLowBtn = (Button) findViewById(R.id.cortisol_low_sugg); //bloodMark = 3
        cortisolHighBtn = (Button) findViewById(R.id.cortisol_high_sugg); //bloodMark = 4
        creatinineLowBtn = (Button) findViewById(R.id.creatinine_low_sugg); //bloodMark = 5
        creatinineHighBtn = (Button) findViewById(R.id.creatinine_high_sugg); //bloodMark = 6
        glucoseLowBtn = (Button) findViewById(R.id.glucose_low_sugg); //bloodMark = 7
        glucoseHighBtn = (Button) findViewById(R.id.glucose_high_sugg); //bloodMark = 8
        ironLowBtn = (Button) findViewById(R.id.iron_low_sugg); //bloodMark = 9
        ironHighBtn = (Button) findViewById(R.id.iron_high_sugg); //bloodMark = 10
        testLowBtn = (Button) findViewById(R.id.test_low_sugg); //bloodMark = 11
        estraLowBtn = (Button) findViewById(R.id.estra_low_sugg); //bloodMark = 12
        estraHighBtn = (Button) findViewById(R.id.estra_high_sugg); //bloodMark = 13
        generalMBtn = (Button) findViewById(R.id.general_m_sugg); //bloodMark = 14
        generalFBtn = (Button) findViewById(R.id.general_f_sugg); //bloodMark = 15

        //Printing our all the general information about the blood markers onto the screen
        printGeneralInfo(tshGeneralInfo, cortisolGeneralInfo, creatinineGeneralInfo, glucoseGeneralInfo,
                        ironGeneralInfo, testGeneralInfo, estraGeneralInfo, generalMaleSugg, generalFemaleSugg);

        printSymptomInfo(tshLow, tshHigh, cortisolLow, cortisolHigh, creatinineLow, creatinineHigh,
                        glucoseLow, glucoseHigh, ironLow, ironHigh, testLow, testHigh, estraLow, estraHigh);


    }//end onCreate

    @SuppressLint("SetTextI18n")
    public void printGeneralInfo(TextView tsh, TextView cortisol, TextView creatinine, TextView glucose,
                                 TextView iron, TextView testosterone, TextView estradiol,
                                 TextView generalMaleSugg, TextView generalFemaleSugg){
        tsh.setText(bloodInfoManager.getTSHGeneral());
        cortisol.setText(bloodInfoManager.getCortisolGeneral());
        creatinine.setText(bloodInfoManager.getCreatinineGeneral());
        glucose.setText(bloodInfoManager.getGlucoseGeneral());
        iron.setText(bloodInfoManager.getIronGeneral());
        testosterone.setText(bloodInfoManager.getTestGeneral());
        estradiol.setText(bloodInfoManager.getEstraGeneral());

        generalMaleSugg.setText("If you are not aware of any specific deficiencies and have any of the " +
                "following symptoms including heart condition risk, lack of deep sleep, improper digestion, " +
                "numbness and weakness of limbs or memory loss, check out Thrives general recommendations " +
                "that might be a quick fix.");

        generalFemaleSugg.setText("If you are not aware of any specific deficiencies and have any of " +
                "the following symptoms including severe pms, extreme fatigue, depression, lack of sleep, " +
                "hair fall or skin or nail problems, check out Thrives general recommendations that might be a quick fix.");

    }//end printGeneralInfo

    public void printSymptomInfo(TextView tshLow, TextView tshHigh, TextView cortisolLow, TextView cortisolHigh,
                                 TextView creatinineLow, TextView creatinineHigh, TextView glucoseLow,
                                 TextView glucoseHigh, TextView ironLow, TextView ironHigh, TextView testLow,
                                 TextView testHigh, TextView estraLow, TextView estraHigh){
        tshLow.setText(bloodInfoManager.getTSHLow());
        tshHigh.setText(bloodInfoManager.getTSHHigh());
        cortisolLow.setText(bloodInfoManager.getCortisolLow());
        cortisolHigh.setText(bloodInfoManager.getCortisolHigh());
        creatinineLow.setText(bloodInfoManager.getCreatinineLow());
        creatinineHigh.setText(bloodInfoManager.getCreatinineHigh());
        glucoseLow.setText(bloodInfoManager.getGlucoseLow());
        glucoseHigh.setText(bloodInfoManager.getGlucoseHigh());
        ironLow.setText(bloodInfoManager.getIronLow());
        ironHigh.setText(bloodInfoManager.getIronHigh());
        testLow.setText(bloodInfoManager.getTestLow());
        testHigh.setText(bloodInfoManager.getTestHigh());
        estraLow.setText(bloodInfoManager.getEstraLow());
        estraHigh.setText(bloodInfoManager.getEstraHigh());
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