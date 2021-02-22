package com.example.comp3350;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent begin = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(begin);

        Spinner workout_spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> workout_adapter = ArrayAdapter.createFromResource(this, R.array.workouts, android.R.layout.simple_spinner_item);
        workout_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workout_spinner.setAdapter(workout_adapter);
        workout_spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}