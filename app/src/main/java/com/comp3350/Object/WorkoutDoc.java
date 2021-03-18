package com.comp3350.Object;

public enum WorkoutDoc { //enum of workout document
    ToneUp("_ToneUp_Doc.pdf"),
    BuildMuscle("_BuildMuscle_Doc.pdf"),
    FatLoss("_FatLoss_Doc.pdf");

    String file_name; //second part of file name

    WorkoutDoc(String file_name) {
        this.file_name = file_name;
    }

    public String getFileName() { //get second part of file name
        return file_name;
    }
}
