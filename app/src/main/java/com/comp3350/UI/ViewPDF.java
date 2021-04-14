package com.comp3350.UI;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.R;
import com.github.barteksc.pdfviewer.PDFView;

public class ViewPDF extends AppCompatActivity {

    PDFView pdf_result;
    String output_file;
    TextView file_name; //for testing, not showing on UI

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view);
        file_name = findViewById(R.id.pdf_fileName); //for testing, not showing on UI

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            output_file = bundle.getString("fileName"); //get output file name
            file_name.setText(output_file);
        }

        pdf_result = (PDFView) findViewById(R.id.pdfView);
        pdf_result.fromAsset(output_file).load();
    }
}
