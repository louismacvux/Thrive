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

import com.comp3350.Database.DatabaseServices;
import com.comp3350.Object.User;
import com.comp3350.Object.WorkoutDoc;
import com.comp3350.R;

public class WorkoutSuggestion extends AppCompatActivity {

    Button next;
    String gender;
    WorkoutDoc selected_workout; //workout enum

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_suggestion);

        Intent intent = getIntent();
<<<<<<< Updated upstream
        DatabaseHelper dbHelper = new DatabaseHelper(DatabaseServices.getDBPathName());
=======
        DatabaseHelper dbHelper = new DatabaseHelper();
>>>>>>> Stashed changes
        String currentUser = intent.getStringExtra("currentUser");

        User current= dbHelper.getSomeone(currentUser); //get current user from database
        gender = current.getGender(); //get gender of current user

        Spinner workout_spinner = findViewById(R.id.spinner_workout);
        workout_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        selected_workout = WorkoutDoc.ToneUp; //Tone up plan
                        break;
                    case 1:
                        selected_workout = WorkoutDoc.BuildMuscle; //Build muscle plan
                        break;
                    case 2:
                        selected_workout = WorkoutDoc.FatLoss; //Lose fat plan
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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pdfViewIntent = new Intent(WorkoutSuggestion.this, ViewPDF.class);
                Bundle bundle = new Bundle();
                bundle.putString("fileName", gender + selected_workout.getFileName()); //gender is the first part of the file name, string get from workout enum is the second part of the file name
                pdfViewIntent.putExtras(bundle);
                startActivity(pdfViewIntent);
            }
        });
    }

    /*public void suggestResult (View view) {
        Intent pdfViewIntent = new Intent(WorkoutSuggestion.this, ViewPDF.class);
        Bundle bundle = new Bundle();
        bundle.putString("fileName", gender + selected_workout.getFileName()); //gender is the first part of the file name, string get from workout enum is the second part of the file name
        pdfViewIntent.putExtras(bundle);
        startActivity(pdfViewIntent);
    }*/

}
