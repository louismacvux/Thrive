package com.comp3350.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.comp3350.R;
import com.github.barteksc.pdfviewer.PDFView;

public class viewBloodOptimizer extends AppCompatActivity {
    
    PDFView pdfView;
    private static int selected_blood_sugg = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_blood_optimizer);

        pdfView = (PDFView) findViewById(R.id.pdfView);
        
        //blood optimizer - self check
        //brings up the pdf for each of the symptoms accordingly
        if (selected_blood_sugg != -1){
            switch(selected_blood_sugg){
                case 1 : pdfView.fromAsset("TSH(Low).pdf").load(); break; //low TSH
                case 2 : pdfView.fromAsset("TSH(High).pdf").load(); break; //high TSH
                case 3 : pdfView.fromAsset("Cortisol(High).pdf").load(); break; //high cortisol
                case 4 : pdfView.fromAsset("Creatinine(High).pdf").load(); break; //high creatinine
                case 5 : pdfView.fromAsset("Glucose(High).pdf").load(); break; //high glucose
                case 6 : pdfView.fromAsset("Iron(Low).pdf").load(); break; //low iron
                case 7 : pdfView.fromAsset("Testosterone(Low).pdf").load(); break; //low testosterone
                case 8 : pdfView.fromAsset("Estrodial(Low).pdf").load(); break; //low estradiol
                case 9 : pdfView.fromAsset("Estrodial(High).pdf").load(); break; //high estradiol
                case 10 : pdfView.fromAsset("GeneralMaleRecom..pdf").load(); break; //Male no symptoms
                case 11 : pdfView.fromAsset("GeneralFemaleRecom..pdf").load(); break; //Female no symptoms
            }
        }

    }//end onCreate

    public void setBloodMark(int bloodMark){
        selected_blood_sugg = bloodMark;
    }
}//end class