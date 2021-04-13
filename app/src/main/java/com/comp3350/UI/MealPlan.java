package com.comp3350.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Object.MealDoc;
import com.comp3350.Object.User;
import com.comp3350.R;

public class MealPlan extends AppCompatActivity {

    User current;
    MealDoc selected = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        Intent i = getIntent();
        DatabaseHelper dbHelper = new DatabaseHelper();

        String currentUser = i.getStringExtra("currentUser");
        current = dbHelper.getSomeone(currentUser);

        //non-vegetarian
        Spinner nonVegSpin = findViewById(R.id.NonVegSpin);
        nonVegSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: break;
                    case 1: selected = MealDoc.NonVeg3100; break;
                    case 2: selected = MealDoc.NonVeg2600; break;
                    case 3: selected = MealDoc.NonVeg2300; break;
                    case 4: selected = MealDoc.NonVeg1900; break;
                }
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                if (selected != null)
                    showMeal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        //vegetarian
        Spinner vegSpin = findViewById(R.id.VegSpin);
        vegSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: break;
                    case 1: selected = MealDoc.Veg3100; break;
                    case 2: selected = MealDoc.Veg2600; break;
                    case 3: selected = MealDoc.Veg2200; break;
                    case 4: selected = MealDoc.Veg1800; break;
                }
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
                if (selected != null)
                    showMeal();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    void showMeal()
    {
        Intent pdfViewIntent = new Intent(MealPlan.this, ViewPDF.class);
        Bundle bundle = new Bundle();
        bundle.putString("fileName", selected.getFileName());
        pdfViewIntent.putExtras(bundle);
        startActivity(pdfViewIntent);
    }


    //the onClick caller for this function is in the 'activity_meal_plan.xml' file
    public void gotoBMI(View v) {
        Intent intent = new Intent(MealPlan.this, WellnessCalculator.class);
        intent.putExtra("currentUser", current.getName());
        startActivity(intent);
    }

    //the onClick caller for this function is in the 'activity_meal_plan.xml' file
    public void gotoRecipes(View v) {
        Intent pdfViewIntent = new Intent(MealPlan.this,ViewPDF.class);
        Bundle bundle = new Bundle();
        bundle.putString("fileName", "recipes.pdf");
        pdfViewIntent.putExtras(bundle);
        startActivity(pdfViewIntent);
    }
}