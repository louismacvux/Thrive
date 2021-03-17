package com.comp3350.UI;

import com.comp3350.Database.DatabaseHelper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.R;

public class BloodOptimizer extends AppCompatActivity {
    private double wbc, rbc, hemoglobin, hematocrit, mcv, mch, mchc, rdw, platelet_count, mpv, neutrophils, lymphocytes, monocytes,
            eosinophils, basophils, sedimentation_rate, creatinine, egfr = 0; //to store all the collected data

    Button submit;

    private EditText enterWbc, enterRbc, enterHemoglobin, enterHematocrit, enterMcv, enterMch, enterMchc, enterRdw, enterPlatelet, enterMpv, enterNeutrophils, enterLymphocytes,
            enterMonocytes, enterEosinophils, enterBasophils, enterSedimentation_rate, enterCreatinine, enterEgfr; //to get data from the user


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_optimizer);

        //get all the values entered by the user
        enterWbc = findViewById(R.id.enter_wbc_count);
        enterRbc = findViewById(R.id.enter_rbc_count);
        enterHemoglobin = findViewById(R.id.enter_hemoglobin_count);
        enterHematocrit = findViewById(R.id.enter_hematocrit_count);
        enterMcv = findViewById(R.id.enter_mcv_count);
        enterMch = findViewById(R.id.enter_mch_count);
        enterMchc = findViewById(R.id.enter_mchc_count);
        enterRdw = findViewById(R.id.enter_rdw_count);
        enterPlatelet = findViewById(R.id.enter_platelet_count);
        enterMpv = findViewById(R.id.enter_mpv_count);
        enterNeutrophils = findViewById(R.id.enter_neutrophilis_count);
        enterLymphocytes = findViewById(R.id.enter_lymphocytes_count);
        enterMonocytes = findViewById(R.id.enter_monocytes_count);
        enterEosinophils = findViewById(R.id.enter_eosinophils_count);
        enterBasophils = findViewById(R.id.enter_basophils_count);
        enterSedimentation_rate = findViewById(R.id.enter_sedimentation_rate_count);
        enterCreatinine = findViewById(R.id.enter_creatinine_count);
        enterEgfr = findViewById(R.id.enter_egfr_count);

        submit = findViewById(R.id.button_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //we need to make sure every feild is filled out
                if (enterWbc.getText().toString().equals("") || enterRbc.getText().toString().equals("") || enterHemoglobin.getText().toString().equals("") || enterHematocrit.getText().toString().equals("")
                        || enterMcv.getText().toString().equals("") || enterMch.getText().toString().equals("") || enterMchc.getText().toString().equals("") || enterRdw.getText().toString().equals("")
                        || enterPlatelet.getText().toString().equals("") || enterMpv.getText().toString().equals("") || enterNeutrophils.getText().toString().equals("") || enterLymphocytes.getText().toString().equals("")
                        || enterMonocytes.getText().toString().equals("") || enterEosinophils.getText().toString().equals("") || enterBasophils.getText().toString().equals("") || enterSedimentation_rate.getText().toString().equals("")
                        || enterCreatinine.getText().toString().equals("") || enterEgfr.getText().toString().equals("")) {
                    Toast.makeText(BloodOptimizer.this, "Make sure to fill out all feilds!",
                            Toast.LENGTH_LONG).show();
                } else {
                    //make sure each value entered is indeed a number
                    //Technically this is not needed however its a good fail safe
                    try {
                        wbc = Double.parseDouble(enterWbc.getText().toString());
                        rbc = Double.parseDouble(enterRbc.getText().toString());
                        hemoglobin = Double.parseDouble(enterHemoglobin.getText().toString());
                        hematocrit = Double.parseDouble(enterHematocrit.getText().toString());
                        mcv = Double.parseDouble(enterMcv.getText().toString());
                        mch = Double.parseDouble(enterMch.getText().toString());
                        mchc = Double.parseDouble(enterMchc.getText().toString());
                        rdw = Double.parseDouble(enterRdw.getText().toString());
                        platelet_count = Double.parseDouble(enterPlatelet.getText().toString());
                        mpv = Double.parseDouble(enterMpv.getText().toString());
                        neutrophils = Double.parseDouble(enterNeutrophils.getText().toString());
                        lymphocytes = Double.parseDouble(enterLymphocytes.getText().toString());
                        monocytes = Double.parseDouble(enterMonocytes.getText().toString());
                        eosinophils = Double.parseDouble(enterEosinophils.getText().toString());
                        basophils = Double.parseDouble(enterBasophils.getText().toString());
                        sedimentation_rate = Double.parseDouble(enterSedimentation_rate.getText().toString());
                        creatinine = Double.parseDouble(enterCreatinine.getText().toString());
                        egfr = Double.parseDouble(enterEgfr.getText().toString());
                        Intent registerIntent = new Intent(BloodOptimizer.this, com.comp3350.UI.RegisterActivity.class);
                        startActivity(registerIntent);
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException: " + e.getMessage());
                        Toast.makeText(BloodOptimizer.this, "One of the entry's wasn't valid please try again",
                                Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

    }



}