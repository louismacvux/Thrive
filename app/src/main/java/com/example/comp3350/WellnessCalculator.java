package com.example.comp3350;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class WellnessCalculator extends AppCompatActivity {

    //variable that user might want to enter manually
    EditText txtWeight;
    EditText txtHeight;

    Button submitData;
    Button calculate;

    double weight;
    double height;
    double result;

    Intent intent;
    User currentUser;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellness_calculator);

        txtWeight = findViewById(R.id.edittext_new_weight);
        txtHeight = findViewById(R.id.edittext_new_height);
        submitData = findViewById(R.id.button_custom);
        calculate = findViewById(R.id.button_calculate);


        submitData.setOnClickListener(v -> {
            weight = Double.parseDouble(txtWeight.getText().toString());
            height = Double.parseDouble(txtHeight.getText().toString());

            result = CalculateBMI(weight, height);

            Intent ShowResult = new Intent(WellnessCalculator.this, WellnessResult.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("weight", weight);
            bundle.putDouble("height", height);
            bundle.putDouble("result", result);
            ShowResult.putExtras(bundle);
            startActivity(ShowResult);

        });


        calculate.setOnClickListener(v -> {
            String userName = intent.getStringExtra("currentUser");
            currentUser = dbHelper.getSomeone(userName);

            result = CalculateBMI(currentUser.getWeight(), currentUser.getHeight());

            Intent ShowResult = new Intent(WellnessCalculator.this, WellnessResult.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("weight", currentUser.getWeight());
            bundle.putDouble("height", currentUser.getHeight());
            bundle.putDouble("result", result);
            ShowResult.putExtras(bundle);
            startActivity(ShowResult);
        });

    }

    private double CalculateBMI(double weightInput, double heightInput){
        //convert weight from pounds to kilograms. 1kb = 2.2lb
        weight = weightInput/2.2;
        //convert height from centimeters to meters. 1cm = 0.01m
        height = heightInput/100;
        return weight/(height*height);
    }


}

