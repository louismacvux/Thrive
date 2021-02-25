package com.example.comp3350;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class WorkoutSuggestion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button next;
    int selected_workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_suggestion);

        Spinner workout_spinner = findViewById(R.id.spinner);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.workout_suggestion);
        //adapter.setDropDownViewResource(R.layout.workout_suggestion);
        //workout_spinner.setAdapter(adapter);
        workout_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        selected_workout = 0;
                        break;
                    case 1:
                        selected_workout = 1;
                        break;
                    case 2:
                        selected_workout = 2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        next = (Button)findViewById(R.id.button_next);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void suggestResult (View view) {
        Intent pdfViewIntent = new Intent(WorkoutSuggestion.this, ViewPDF.class);
        Bundle bundle = new Bundle();
        bundle.putInt("goal", selected_workout);
        pdfViewIntent.putExtras(bundle);
        startActivity(pdfViewIntent);
    }
}
