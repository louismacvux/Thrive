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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness_result);

        show_height = (TextView) findViewById(R.id.show_height);
        show_weight = (TextView) findViewById(R.id.show_weight);
        show_result = (TextView) findViewById(R.id.show_result);
        show_range = (TextView) findViewById(R.id.range);

        Intent intent = getIntent();
        String weight = intent.getStringExtra("weight");
        String height = intent.getStringExtra("height");
        String result = intent.getStringExtra("result");

        show_height.setText(height);
        show_weight.setText(weight);
        show_result.setText(result);

        double dresult = Double.parseDouble(result);
        if (dresult > 0 && dresult < 18.5)
            show_range.setText("You are underweight.");
        else if (dresult >= 18.5 && dresult <= 24.9)
            show_range.setText("Your weight is healthu.");
        else if (dresult >= 25 && dresult <= 29)
            show_range.setText("You are overweight");
        else
            show_range.setText("You are obese.");

    }
}