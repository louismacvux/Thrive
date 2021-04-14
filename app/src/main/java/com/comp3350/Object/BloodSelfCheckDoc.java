package com.comp3350.Object;

public enum BloodSelfCheckDoc {
    TSHHigh("TSH(High).pdf"),
    TSHLow("TSH(Low).pdf"),
    CortisolLow("Cortisol(Low).pdf"),
    CortisolHigh("Cortisol(High).pdf"),
    CreatinineLow("Creatinine(Low).pdf"),
    CreatinineHigh("Creatinine(High).pdf"),
    GlucoseLow("Glucose(Low).pdf"),
    GlucoseHigh("Glucose(High).pdf"),
    IronLow("Iron(Low).pdf"),
    IronHigh("Iron(High).pdf"),
    TestosteroneLow("Testosterone(Low).pdf"),
    EstradiolLow("Estradiol(Low).pdf"),
    EstradiolHigh("Estradiol(High).pdf"),
    MaleRecomm("GeneralMaleRecom.pdf"),
    FemaleRecomm("GeneralFemaleRecom.pdf");

    String file_name;

    BloodSelfCheckDoc(String file_name) {
        this.file_name = file_name;
    }

    public String getFileName() { //get second part of file name
        return file_name;
    }
}
