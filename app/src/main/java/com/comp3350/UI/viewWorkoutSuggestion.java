package com.comp3350.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.R;
import com.github.barteksc.pdfviewer.PDFView;

public class viewWorkoutSuggestion extends AppCompatActivity {

    PDFView pdf_result;
    int selected_gender = -1;
    int selected_workout = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pdf_workout_suggestion);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            selected_gender = bundle.getInt("gender");
            selected_workout = bundle.getInt("workout");
        }

        //workout suggestion
        if(selected_gender == 0) //Male
            maleWorkout();
        else if(selected_gender == 1) //Female
            femaleWorkout();

    }//end onCreate

    public void maleWorkout(){
        pdf_result = (PDFView) findViewById(R.id.pdfView);
        if (selected_workout == 0) { //Tone up
            pdf_result.fromAsset("Doc1.pdf").load();
        } else if (selected_workout == 1) { //Build muscle
            pdf_result.fromAsset("Doc2.pdf").load();
        } else if (selected_workout == 2) { //Loose fat
            pdf_result.fromAsset("Doc3.pdf").load();
        }
    }//end makeWorkout

    public void femaleWorkout(){
        pdf_result = (PDFView) findViewById(R.id.pdfView);
        if (selected_workout == 0) { //Tone up
            pdf_result.fromAsset("Doc4.pdf").load();
        } else if (selected_workout == 1) { //Build muscle
            pdf_result.fromAsset("Doc5.pdf").load();
        } else if (selected_workout == 2) { //Loose fat
            pdf_result.fromAsset("Doc6.pdf").load();
        }
    }//end femaleWorkout


}//end class
