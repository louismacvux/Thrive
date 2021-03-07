package com.example.comp3350;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WellnessResult extends AppCompatActivity {

    TextView show_weight;
    TextView show_height;
    TextView show_result;
    TextView show_range;

    double weight;
    double height;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness_result);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            weight = bundle.getDouble("weight");
            height = bundle.getDouble("height");
            result = bundle.getDouble("result");
        }

        show_height = findViewById(R.id.show_height);
        show_weight = findViewById(R.id.show_weight);
        show_result = findViewById(R.id.show_result);
        show_range = findViewById(R.id.range);

        show_height.setText(String.format("%.2f", height));
        show_weight.setText(String.format("%.2f", weight));
        show_result.setText(String.format("%.2f", result));

        if (result > 0 && result < 18.5)
            show_range.setText("You are underweight.");
        else if (result >= 18.5 && result <= 24.9)
            show_range.setText("Your weight is normal.");
        else if (result >= 25 && result <= 29)
            show_range.setText("You are overweight");
        else
            show_range.setText("You are obese.");

    }
}