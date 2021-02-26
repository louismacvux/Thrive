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

    int weight;
    int height;

    Intent intent;
    User currentUser;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellness_calculator);

        txtWeight = (EditText) findViewById(R.id.edittext_new_weight);
        txtHeight = (EditText) findViewById(R.id.edittext_new_height);
        submitData = (Button) findViewById(R.id.button_custom);
        calculate = (Button) findViewById(R.id.button_calculate);


        submitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = Integer.parseInt(txtWeight.getText().toString());
                height = Integer.parseInt(txtHeight.getText().toString());

                double result = CalculateBMI(weight, height);

                Intent ShowResult = new Intent(WellnessCalculator.this, WellnessResult.class);
                ShowResult.putExtra("weight", weight);
                ShowResult.putExtra("height", height);
                ShowResult.putExtra("result", result);
                startActivity(ShowResult);

            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = intent.getStringExtra("currentUser");
                currentUser = dbHelper.getSomeone(userName);

                double result = CalculateBMI(currentUser.getWeight(), currentUser.getHeight());

                Intent ShowResult = new Intent(WellnessCalculator.this, WellnessResult.class);
                ShowResult.putExtra("weight", currentUser.getWeight());
                ShowResult.putExtra("height", currentUser.getHeight());
                ShowResult.putExtra("result", result);
                startActivity(ShowResult);
            }
        });

    }

    private double CalculateBMI(int weight, double height){
        //convert weight from pounds to kilograms. 1kb = 2.2lb
        weight = (int) (weight/2.2);
        //convert height from centimeters to meters. 1cm = 0.01m
        height = height/100;
        return weight/(height*height);
    }


}

