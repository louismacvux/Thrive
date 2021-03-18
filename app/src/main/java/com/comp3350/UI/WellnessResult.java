package com.comp3350.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.comp3350.R;

public class WellnessResult extends AppCompatActivity {

    TextView show_mc;
    TextView show_weight;
    TextView show_height;
    TextView show_bmi;
    TextView show_range;

    double maintenance_calories;
    double weight;
    double height;
    double bmi;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness_result);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            maintenance_calories = bundle.getDouble("mc");
            weight = bundle.getDouble("weight");
            height = bundle.getDouble("height");
            bmi = bundle.getDouble("bmi");
        }

        show_mc = findViewById(R.id.mc_result);
        show_weight = findViewById(R.id.weight_result);
        show_height = findViewById(R.id.height_result);
        show_bmi = findViewById(R.id.bmi_result);
        show_range = findViewById(R.id.health_range);

        show_mc.setText(String.format("%.2f", maintenance_calories) + " Calories/day are needed to maintain your current body composition.");
        show_weight.setText(String.format("%.2f", weight));
        show_height.setText(String.format("%.2f", height));
        show_bmi.setText(String.format("%.2f", bmi));

        if (bmi > 0 && bmi < 18.5)
            show_range.setText("You are underweight.");
        else if (bmi >= 18.5 && bmi <= 24.9)
            show_range.setText("Your weight is normal.");
        else if (bmi >= 25 && bmi <= 29)
            show_range.setText("You are overweight.");
        else
            show_range.setText("You are obese.");

    }
}