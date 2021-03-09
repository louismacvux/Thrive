package com.comp3350.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ViewPDF extends AppCompatActivity {

    PDFView pdf_result;
    int selected_gender = -1;
    int selected_workout = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            selected_gender = bundle.getInt("gender");
            selected_workout = bundle.getInt("workout");
        }

        if(selected_gender == 0) { //Male
            if (selected_workout == 0) { //Tone up
                // Doc1.pdf
                pdf_result = (PDFView) findViewById(R.id.pdfView);
                pdf_result.fromAsset("Doc1.pdf").load();
            } else if (selected_workout == 1) { //Build muscle
                // Doc2.pdf
                pdf_result = (PDFView) findViewById(R.id.pdfView);
                pdf_result.fromAsset("Doc2.pdf").load();
            } else if (selected_workout == 2) { //Loose fat
                // Doc3.pdf
                pdf_result = (PDFView) findViewById(R.id.pdfView);
                pdf_result.fromAsset("Doc3.pdf").load();
            }
        }
        else if(selected_gender == 1) { //Female
            if (selected_workout == 0) { //Tone up
                // Doc4.pdf
                pdf_result = (PDFView) findViewById(R.id.pdfView);
                pdf_result.fromAsset("Doc4.pdf").load();
            } else if (selected_workout == 1) { //Build muscle
                // Doc5.pdf
                pdf_result = (PDFView) findViewById(R.id.pdfView);
                pdf_result.fromAsset("Doc5.pdf").load();
            } else if (selected_workout == 2) { //Loose fat
                // Doc6.pdf
                pdf_result = (PDFView) findViewById(R.id.pdfView);
                pdf_result.fromAsset("Doc6.pdf").load();
            }
        }

    }
}
