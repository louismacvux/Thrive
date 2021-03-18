package com.comp3350.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.comp3350.Logic.BloodInformationManager;
import com.comp3350.R;

public class BloodInformation extends AppCompatActivity {
    
    TextView tshGeneralInfo, cortisolGeneralInfo, creatinineGeneralInfo, glucoseGeneralInfo,
             ironGeneralInfo, testGeneralInfo, estraGeneralInfo;
    TextView generalMaleSugg, generalFemaleSugg;

    TextView tshLow, tshHigh, cortisolHigh, creatinineHigh, glucoseLow,
             glucoseHigh, ironLow, testLow, estraLow, estraHigh;

    Button tshLowBtn, tshHighBtn, cortisolHighBtn, creatinineHighBtn, glucoseHighBtn, ironLowBtn,
           testLowBtn, estraLowBtn, estraHighBtn, generalMBtn, generalFBtn;

    BloodInformationManager bloodInfoManager = new BloodInformationManager();

    int bloodMark = -1; //for bundle -> viewPDF

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_information);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            bloodMark = bundle.getInt("bloodMark");
        }

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
        cortisolHigh = (TextView) findViewById(R.id.cortisol_high_info);
        creatinineHigh = (TextView) findViewById(R.id.creatinine_high_info);
        glucoseLow = (TextView) findViewById(R.id.glucose_low_info);
        glucoseHigh = (TextView) findViewById(R.id.glucose_high_info);
        ironLow = (TextView) findViewById(R.id.iron_low_info);
        testLow = (TextView) findViewById(R.id.test_low_info);
        estraLow = (TextView) findViewById(R.id.estra_low_info);
        estraHigh = (TextView) findViewById(R.id.estra_high_info);
        //suggestion buttons
        tshLowBtn = (Button) findViewById(R.id.tsh_low_sugg); //bloodMark = 1
        tshHighBtn = (Button) findViewById(R.id.tsh_high_sugg); //bloodMark = 2
        cortisolHighBtn = (Button) findViewById(R.id.cortisol_high_sugg); //bloodMark = 3
        creatinineHighBtn = (Button) findViewById(R.id.creatinine_high_sugg); //bloodMark = 4
        glucoseHighBtn = (Button) findViewById(R.id.glucose_high_sugg); //bloodMark = 5
        ironLowBtn = (Button) findViewById(R.id.iron_low_sugg); //bloodMark = 6
        testLowBtn = (Button) findViewById(R.id.test_low_sugg); //bloodMark = 7
        estraLowBtn = (Button) findViewById(R.id.estra_low_sugg); //bloodMark = 8
        estraHighBtn = (Button) findViewById(R.id.estra_high_sugg); //bloodMark = 9
        generalMBtn = (Button) findViewById(R.id.general_m_sugg); //bloodMark = 10
        generalFBtn = (Button) findViewById(R.id.general_f_sugg); //bloodMark = 11


        //Printing our all the general information about the blood markers onto the screen
        printGeneralInfo(tshGeneralInfo, cortisolGeneralInfo, creatinineGeneralInfo, glucoseGeneralInfo,
                        ironGeneralInfo, testGeneralInfo, estraGeneralInfo, generalMaleSugg, generalFemaleSugg);

        printSymptomInfo(tshLow, tshHigh, cortisolHigh, creatinineHigh,
                        glucoseLow, glucoseHigh, ironLow, testLow, estraLow, estraHigh);

        //suggestions
        tshLowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 1;
                suggestions(bloodMark);
            }
        });
        tshHighBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 2;
                suggestions(bloodMark);
            }
        });
        cortisolHighBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 3;
                suggestions(bloodMark);
            }
        });
        creatinineHighBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 4;
                suggestions(bloodMark);
            }
        });
        glucoseHighBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 5;
                suggestions(bloodMark);
            }
        });
        ironLowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 6;
                suggestions(bloodMark);
            }
        });
        testLowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 7;
                suggestions(bloodMark);
            }
        });
        estraLowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 8;
                suggestions(bloodMark);
            }
        });
        estraHighBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 9;
                suggestions(bloodMark);
            }
        });
        generalMBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 10;
                suggestions(bloodMark);
            }
        });
        generalFBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodMark = 11;
                suggestions(bloodMark);
            }
        });

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

    public void printSymptomInfo(TextView tshLow, TextView tshHigh, TextView cortisolHigh,
                                 TextView creatinineHigh, TextView glucoseLow,
                                 TextView glucoseHigh, TextView ironLow, TextView testLow,
                                 TextView estraLow, TextView estraHigh){
        tshLow.setText(bloodInfoManager.getTSHLow());
        tshHigh.setText(bloodInfoManager.getTSHHigh());
        cortisolHigh.setText(bloodInfoManager.getCortisolHigh());
        creatinineHigh.setText(bloodInfoManager.getCreatinineHigh());
        glucoseLow.setText(bloodInfoManager.getGlucoseLow());
        glucoseHigh.setText(bloodInfoManager.getGlucoseHigh());
        ironLow.setText(bloodInfoManager.getIronLow());
        testLow.setText(bloodInfoManager.getTestLow());
        estraLow.setText(bloodInfoManager.getEstraLow());
        estraHigh.setText(bloodInfoManager.getEstraHigh());
    }//end printSymptomInfo

    //tells the PDF viewer which one to show the user
    public void suggestions (int bloodMark){
        Intent pdfViewIntent = new Intent(BloodInformation.this, viewBloodOptimizer.class);
        viewBloodOptimizer newView = new viewBloodOptimizer();
        newView.setBloodMark(bloodMark);
        startActivity(pdfViewIntent);
    }//end suggestions
}//end class