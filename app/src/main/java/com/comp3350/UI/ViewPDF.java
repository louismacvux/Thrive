package com.comp3350.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ViewPDF extends AppCompatActivity {

    PDFView pdf_result;
    String output_file;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            output_file = bundle.getString("fileName"); //get output file name
        }

        pdf_result = (PDFView) findViewById(R.id.pdfView);
        pdf_result.fromAsset(output_file).load();
    }
}
