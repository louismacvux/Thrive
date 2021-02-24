package com.example.comp3350;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
        String currentUser = intent.getStringExtra("currentUser");

        User current= dbHelper.getSomeone(currentUser);
        Toast.makeText(MainActivity.this, currentUser + " logged in",
                Toast.LENGTH_LONG).show();
    }


}