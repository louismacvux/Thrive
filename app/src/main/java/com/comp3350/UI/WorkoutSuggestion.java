package com.comp3350.UI;

import com.comp3350.Database.DatabaseHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.Object.User;
import com.comp3350.R;

public class WorkoutSuggestion extends AppCompatActivity {

    Button next;
    int selected_gender = -1;
    int selected_workout = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_suggestion);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            selected_gender = bundle.getInt("gender");
        }

        Intent intent = getIntent();
        DatabaseHelper dbHelper = new DatabaseHelper(WorkoutSuggestion.this);
        String currentUser = intent.getStringExtra("currentUser");

        User current= dbHelper.getSomeone(currentUser);
        selected_gender = current.getGenderInt();

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
                        selected_workout = 2; //Lose fat
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
        if(selected_gender == -1) {
            /*Intent intent = getIntent();
            DatabaseHelper dbHelper = new DatabaseHelper(WorkoutSuggestion.this);
            String currentUser = intent.getStringExtra("currentUser");

            User current= dbHelper.getSomeone(currentUser);
            selected_gender = current.getGenderInt();

            Toast.makeText(WorkoutSuggestion.this, "Incorrect gender in user profile", Toast.LENGTH_LONG).show();*/
            Intent GenderSelectionIntent = new Intent(WorkoutSuggestion.this, GenderSelection.class);
            Bundle bundle = new Bundle();
            bundle.putInt("workout", selected_workout);
            GenderSelectionIntent.putExtras(bundle);

            startActivity(GenderSelectionIntent);
        }
        else {
            Intent pdfViewIntent = new Intent(WorkoutSuggestion.this, viewWorkoutSuggestion.class);
            Bundle bundle = new Bundle();
            bundle.putInt("gender", selected_gender);
            bundle.putInt("workout", selected_workout);
            pdfViewIntent.putExtras(bundle);
            startActivity(pdfViewIntent);
        }
    }

}
