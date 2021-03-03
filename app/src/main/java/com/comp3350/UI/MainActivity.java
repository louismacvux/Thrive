package com.comp3350.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.R;
import com.comp3350.Object.User;
import com.comp3350.WorkoutSuggestion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = getIntent();
//        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
//        String currentUser = intent.getStringExtra("currentUser");
//
//        User current= dbHelper.getSomeone(currentUser);
//
//        Intent goToWorkouts = new Intent(MainActivity.this,
//                WorkoutSuggestion.class);
//        goToWorkouts.putExtra("currentUser", current.getName());
//        startActivity(goToWorkouts);
    }


}