package com.comp3350.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.Object.User;
import com.comp3350.R;

import com.comp3350.Logic.Calculator;

public class WellnessCalculator extends AppCompatActivity {

    //variable that user might want to enter manually
    EditText txtWeight;
    EditText txtHeight;
    String string_weight;
    String string_height;

    Button calculate;

    double activity_level;
    double maintenance_calories;
    double weight;
    double height;
    double bmi;

    User currentUser;
    DatabaseHelper dbHelper;
    Calculator calculator;

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
            Intent intent = getIntent();
            dbHelper = new DatabaseHelper();
            String userName = intent.getStringExtra("currentUser");

            currentUser = dbHelper.getSomeone(userName);
            string_weight = txtWeight.getText().toString();
            string_height = txtHeight.getText().toString();

            //Do the calculation
            calculator = new Calculator(string_weight, string_height, currentUser, activity_level);
            calculator.calculate();

            //get back the result
            maintenance_calories = calculator.getMC();
            weight = calculator.getWeightUsed();
            height = calculator.getHeightUsed();
            bmi = calculator.getBMI();

            Bundle bundle = new Bundle();
            Intent ShowResult = new Intent(WellnessCalculator.this, WellnessResult.class);

            bundle.putDouble("mc", maintenance_calories);
            bundle.putDouble("weight", weight);
            bundle.putDouble("height", height);
            bundle.putDouble("bmi", bmi);

            ShowResult.putExtras(bundle);
            startActivity(ShowResult);
        });

    }

}

