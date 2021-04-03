package com.comp3350.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Object.User;
import com.comp3350.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView bmi, bloodOptimizerSelfCheck, workoutPlan, mealPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define the cards
        bmi = (CardView) findViewById(R.id.cardview_bmi);
        bloodOptimizerSelfCheck = (CardView) findViewById(R.id.cardview_bloodOptimizer);
        workoutPlan = (CardView) findViewById(R.id.cardview_workoutPlan);
        mealPlan = (CardView) findViewById(R.id.cardview_mealPlan);

        //adding the click listener
        bmi.setOnClickListener(this);
        bloodOptimizerSelfCheck.setOnClickListener(this);
        workoutPlan.setOnClickListener(this);
        mealPlan.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        Intent intent;
        Intent i = getIntent();
        DatabaseHelper dbHelper = new DatabaseHelper();

        String currentUser = i.getStringExtra("currentUser");
        User current= dbHelper.getSomeone(currentUser);

        //for now only workout suggestion is clickable
        //this if block can be deleted and use the switch block instead once we have all the other classes
        if (v.getId() == R.id.cardview_workoutPlan){
            intent = new Intent(MainActivity.this, WorkoutSuggestion.class);
            intent.putExtra("currentUser", current.getName());
            startActivity(intent);
        }
        else if (v.getId() == R.id.cardview_bloodOptimizer){
            intent = new Intent(MainActivity.this, BloodInformation.class);
            intent.putExtra("currentUser", current.getName());
            startActivity(intent);
        }
        else if (v.getId() == R.id.cardview_bmi){
            intent = new Intent(MainActivity.this, WellnessCalculator.class);
            intent.putExtra("currentUser", current.getName());
            startActivity(intent);
        }
        else if (v.getId() == R.id.cardview_mealPlan){
            intent = new Intent(MainActivity.this, MealPlan.class);
            intent.putExtra("currentUser", current.getName());
            startActivity(intent);
        }

//        switch (v.getId()){
//            case R.id.cardview_bmi : intent = new Intent(this, WellnessCalculator.class); break;
//            case R.id.cardview_bloodOptimizer : intent = new Intent(this, BloodOptimizer.class); break;
//            case R.id.cardview_workoutPlan : intent = new Intent(this, WorkoutSuggestion.class); break;
//            case R.id.cardview_mealPlan : intent = new Intent(this, MealPlan.class); break;
//        }
    }
}