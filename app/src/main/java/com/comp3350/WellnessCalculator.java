package com.example.comp3350;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WellnessCalculator extends AppCompatActivity {

    //variable that user might want to enter manually
    EditText txtWeight;
    EditText txtHeight;

    Button calculate;

    double activity_level;
    double maintenance_calories;
    double weight;
    double height;
    double bmi;

    User currentUser;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wellness_calculator);

        txtWeight = findViewById(R.id.edittext_new_weight);
        txtHeight = findViewById(R.id.edittext_new_height);
        calculate = findViewById(R.id.button_calculate);

        Spinner activity_level_spinner = findViewById(R.id.spinner_activity_level);
        activity_level_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        activity_level = 1.2; //Barely active
                        break;
                    case 1:
                        activity_level = 1.4; //Active
                        break;
                    case 2:
                        activity_level = 1.7; //Highly active
                        break;
                }
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calculate.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            Intent ShowResult = new Intent(WellnessCalculator.this, WellnessResult.class);

            Intent intent = getIntent();
            dbHelper = new DatabaseHelper(WellnessCalculator.this);
            String userName = intent.getStringExtra("currentUser");
            currentUser = dbHelper.getSomeone(userName);

            if (txtWeight.getText().toString().equals("") & txtHeight.getText().toString().equals("")){ //calculate using personal data in profile
                maintenance_calories = activity_level * calculateBMR(currentUser.getGenderInt(), currentUser.getWeight(), currentUser.getHeight(), currentUser.getAge());
                bmi = calculateBMI(currentUser.getWeight(), currentUser.getHeight());
                bundle.putDouble("mc", maintenance_calories);
                bundle.putDouble("weight", currentUser.getWeight());
                bundle.putDouble("height", currentUser.getHeight());
                bundle.putDouble("bmi", bmi);
            }
            else{ //calculate using new custom given data
                weight = Double.parseDouble(txtWeight.getText().toString());
                height = Double.parseDouble(txtHeight.getText().toString());

                maintenance_calories = activity_level * calculateBMR(currentUser.getGenderInt(), weight, height, currentUser.getAge());
                bmi = calculateBMI(weight, height);
                bundle.putDouble("mc", maintenance_calories);
                bundle.putDouble("weight", weight);
                bundle.putDouble("height", height);
                bundle.putDouble("bmi", bmi);
            }

            ShowResult.putExtras(bundle);
            startActivity(ShowResult);
        });

    }

    private double calculateBMI(double weight, double height){
        //convert weight from pounds to kilograms. 1kb = 2.2lb
        double convertedWeight = weight/2.2;
        //convert height from centimeters to meters. 1cm = 0.01m
        double convertedHeight = height/100;
        return convertedWeight/(convertedHeight*convertedHeight);
    }

    private double calculateBMR(int gender, double weight, double height, int age) {
        if(gender == 0) {
            //calculate BMR value of male
            return 66 + (13.7 * weight/2.2) + (5 * height) - (6.8 * age);
        }
        else if(gender == 1) {
            //calculate BMR value of female
            return 655 + (9.6 * weight/2.2) + (1.8 * height) - (4.7 * age);
        }
        else {
            //incorrect BMR due to incorrect gender
            return -1;
        }
    }

}

