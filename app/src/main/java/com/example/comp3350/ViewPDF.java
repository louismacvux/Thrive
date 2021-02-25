package com.example.comp3350;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class ViewPDF extends AppCompatActivity {

    PDFView pdf_result;
    int selected_workout = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            selected_workout = bundle.getInt("goal");
        }

        if(selected_workout == 0) {
            // Doc1.pdf
            pdf_result = (PDFView)findViewById(R.id.pdfView);
            pdf_result.fromAsset("Doc1.pdf").load();
        }
        else if(selected_workout == 1) {
            // Doc2.pdf
            pdf_result = (PDFView)findViewById(R.id.pdfView);
            pdf_result.fromAsset("Doc2.pdf").load();
        }
        else if(selected_workout == 2) {
            // Doc3.pdf
            pdf_result = (PDFView)findViewById(R.id.pdfView);
            pdf_result.fromAsset("Doc3.pdf").load();
        }

    }
}
