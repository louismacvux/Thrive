package com.example.comp3350;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {



    //set variables that are captured on registration page
    EditText txtUsername;
    EditText txtPassword;
    EditText userEmail;
    EditText confirmPassword;
    EditText txtAge;
    EditText txtGender;
    EditText txtWeight;
    EditText txtBMI;

    Button register;

    //variables used to create our User object
    String name;
    String email;
    String gender;
    int age;
    int weight;
    int bmi;

    User newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userEmail = (EditText)findViewById(R.id.edittext_useremail);
        txtUsername = (EditText)findViewById(R.id.edittext_username);
        txtPassword = (EditText)findViewById(R.id.edittext_password);
        confirmPassword = (EditText)findViewById(R.id.edittext_confrim_password);
        txtAge = (EditText)findViewById(R.id.edittext_age);
        txtGender = (EditText)findViewById(R.id.edittext_gender);
        txtWeight = (EditText)findViewById(R.id.edittext_weight);
        txtBMI = (EditText)findViewById(R.id.edittext_bmi);
        register = (Button)findViewById(R.id.button_done_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtUsername.getText().toString();
                email = userEmail.getText().toString();
                gender = txtGender.getText().toString();
                age = Integer.parseInt(txtAge.getText().toString());
                weight = Integer.parseInt(txtWeight.getText().toString());
                bmi = Integer.parseInt(txtBMI.getText().toString());

                //try to make a new user with all the data
                try
                {
                    newUser = new User(-1, name, email, age, weight, gender, bmi);
                }
                //make a new user without any of their data entered
                catch (Exception e)
                {
                    newUser = new User(-1, null, null, -1,
                            -1, null, -1);
                    Toast.makeText(RegisterActivity.this, "Error in creating new user!",
                            Toast.LENGTH_LONG).show();
                }

                //database and helper
                DatabaseHelper dbHelper = new DatabaseHelper(RegisterActivity.this);
                if (dbHelper.addData(newUser)) {

                    Toast.makeText(RegisterActivity.this, "Registration Complete",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Failed to add user to DB...",
                            Toast.LENGTH_LONG).show();
                }
                Intent enterStats = new Intent(RegisterActivity.this,
                        MainActivity.class);
                startActivity(enterStats);
            }
        });
    }

}