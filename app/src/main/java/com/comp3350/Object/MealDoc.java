package com.comp3350.Object;

public enum MealDoc { //enum of meal document
    Veg3100("Veg 3100.pdf"),
    Veg2600("Veg 2600.pdf"),
    Veg2200("Veg 2200.pdf"),
    Veg1800("Veg 1800.pdf"),
    NonVeg3100("Non Veg 3100.pdf"),
    NonVeg2600("Non Veg 2600.pdf"),
    NonVeg2300("Non Veg 2300.pdf"),
    NonVeg1900("Non Veg 1900.pdf");


    String file_name;

    MealDoc(String file_name) {
        this.file_name = file_name;
    }

    public String getFileName() { //get second part of file name
        return file_name;
    }
}
