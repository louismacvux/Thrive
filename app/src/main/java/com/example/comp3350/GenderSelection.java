package com.example.comp3350;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.comp3350.UI.ViewPDF;

public class GenderSelection extends AppCompatActivity {

    Button next;
    int selected_gender = -1;
    int selected_workout = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender_selection);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            selected_workout = bundle.getInt("workout");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(GenderSelection.this);
        builder.setCancelable(true);
        builder.setMessage("Incorrect gender information in user profile.");
        builder.setPositiveButton("OK", (dialog, which) -> dialog.cancel());
        builder.show();

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

        next = (Button)findViewById(R.id.button_save);
    }

    public void suggestResult (View view) {
        Intent pdfViewIntent = new Intent(GenderSelection.this, ViewPDF.class);
        Bundle bundle = new Bundle();
        bundle.putInt("gender", selected_gender);
        bundle.putInt("workout", selected_workout);
        pdfViewIntent.putExtras(bundle);
        startActivity(pdfViewIntent);
    }
}
