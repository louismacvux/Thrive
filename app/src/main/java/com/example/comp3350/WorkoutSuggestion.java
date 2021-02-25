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

public class WorkoutSuggestion extends AppCompatActivity {

    Button next;
    int selected_gender;
    int selected_workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_suggestion);

        Intent intent = getIntent();
        DatabaseHelper dbHelper = new DatabaseHelper(WorkoutSuggestion.this);
        String currentUser = intent.getStringExtra("currentUser");

        User current= dbHelper.getSomeone(currentUser);

        Spinner gender_spinner = findViewById(R.id.spinner_gender);
        gender_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        selected_gender = 0; //Male
                        break;
                    case 1:
                        selected_gender = 1; //Female
                        break;
                }
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner workout_spinner = findViewById(R.id.spinner_workout);
        workout_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        selected_workout = 0; //Tone up
                        break;
                    case 1:
                        selected_workout = 1; //Build muscle
                        break;
                    case 2:
                        selected_workout = 2; //Loose fat
                        break;
                }
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        next = (Button)findViewById(R.id.button_next);
    }

    public void suggestResult (View view) {
        Intent pdfViewIntent = new Intent(WorkoutSuggestion.this, ViewPDF.class);
        Bundle bundle = new Bundle();
        bundle.putInt("gender", selected_gender);
        bundle.putInt("workout", selected_workout);
        pdfViewIntent.putExtras(bundle);
        startActivity(pdfViewIntent);
    }
}
