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

    TextView tshLow, tshHigh, cortisolHigh, creatinineHigh, glucoseLow,
             glucoseHigh, ironLow, testLow, estraLow, estraHigh;

    Button tshLowBtn, tshHighBtn, cortisolHighBtn, creatinineHighBtn, glucoseHighBtn, ironLowBtn,
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

    //onclick
    public void tshLow(View v){ suggestions(1); }
    public void tshHigh(View v){ suggestions(2); }
    public void cortisolHigh(View v){ suggestions(3); }
    public void creatinineHigh(View v){ suggestions(4); }
    public void glucoseHigh(View v){ suggestions(5); }
    public void ironLow(View v){ suggestions(6); }
    public void testLow(View v){ suggestions(7); }
    public void estraLow(View v){ suggestions(8); }
    public void estraHigh(View v){ suggestions(9); }
    public void maleSugg(View v){ suggestions(10); }
    public void femaleSugg(View v){ suggestions(11); }

    //tells the PDF viewer which one to show the user
    public void suggestions (int bloodMark){
        Intent pdfViewIntent = new Intent(BloodInformation.this, ViewPDF.class);
        Bundle bundle = new Bundle();

        switch(bloodMark){
            case 1 : selected_sugg = BloodSelfCheckDoc.TSHLow; break; //low TSH
            case 2 : selected_sugg = BloodSelfCheckDoc.TSHHigh; break; //high TSH
            case 3 : selected_sugg = BloodSelfCheckDoc.CortisolHigh; break; //high cortisol
            case 4 : selected_sugg = BloodSelfCheckDoc.CreatinineHigh; break; //high creatinine
            case 5 : selected_sugg = BloodSelfCheckDoc.GlucoseHigh; break; //high glucose
            case 6 : selected_sugg = BloodSelfCheckDoc.IronLow; break; //low iron
            case 7 : selected_sugg = BloodSelfCheckDoc.TestosteroneLow; break; //low testosterone
            case 8 : selected_sugg = BloodSelfCheckDoc.EstradiolLow; break; //low estradiol
            case 9 : selected_sugg = BloodSelfCheckDoc.EstradiolHigh; break; //high estradiol
            case 10 : selected_sugg = BloodSelfCheckDoc.MaleRecomm; break; //Male no symptoms
            case 11 : selected_sugg = BloodSelfCheckDoc.FemaleRecomm; break; //Female no symptoms
        }

        bundle.putString("fileName", selected_sugg.getFileName());
        pdfViewIntent.putExtras(bundle);
        startActivity(pdfViewIntent);
    }
}//end class