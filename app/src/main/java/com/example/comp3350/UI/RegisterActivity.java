package com.example.comp3350.UI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comp3350.Database.DatabaseHelper;
import com.example.comp3350.UI.LoginActivity;
import com.example.comp3350.R;
import com.example.comp3350.Logic.RegisterManager;
import com.example.comp3350.Object.User;

public class RegisterActivity extends AppCompatActivity {

    //set variables that are captured on registration page
    private TextView txtEmail, txtUsername, txtPassword, txtConfirmPassword;
    private RadioGroup radioGroupGender;
//    private String chosenGender;
    private TextView txtAge, txtWeight, txtHeight;
    Button register;

    //variables used to create our User object
    private String email;
    private String name;
    private String password;
    private String rePass;
    private String gender;
    private int age;
    private int weight;
    private double height;

    private User newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtEmail = findViewById(R.id.edittext_useremail);
        txtUsername = findViewById(R.id.edittext_username);
        txtPassword = findViewById(R.id.edittext_password);
        txtConfirmPassword = findViewById(R.id.edittext_confrim_password);
        txtAge = findViewById(R.id.edittext_age);
//        txtGender = (EditText)findViewById(R.id.edittext_gender);
        txtWeight = findViewById(R.id.edittext_weight);
        txtHeight = findViewById(R.id.edittext_height);
        register = findViewById(R.id.button_done_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper dbHelper = new DatabaseHelper(RegisterActivity.this);
                email = txtEmail.getText().toString();
                name = txtUsername.getText().toString();

//                gender = txtGender.getText().toString();

//                if (!txtAge.getText().toString().equals(""))
//                {
//                    //try to get numeric values from age, weight and height
//                    try
//                    {
//                        age = Integer.parseInt(txtAge.getText().toString());
//                    }
//                    catch (NumberFormatException e)
//                    {
//                        System.out.println("NumberFormatException: " + e.getMessage());
//                        Toast.makeText(RegisterActivity.this, "Please enter a number for AGE",
//                                Toast.LENGTH_LONG).show();
//                    }
//                }
//                if (!txtWeight.getText().toString().equals(""))
//                {
//                    try
//                    {
//                        weight = Integer.parseInt(txtWeight.getText().toString());
//                    }
//                    catch (NumberFormatException e)
//                    {
//                        System.out.println("NumberFormatException: " + e.getMessage());
//                        Toast.makeText(RegisterActivity.this, "Please enter a number for WEIGHT",
//                                Toast.LENGTH_LONG).show();
//                    }
//                }
//
//                if (!txtHeight.getText().toString().equals(""))
//                {
//                    try
//                    {
//                        height = Double.parseDouble(txtHeight.getText().toString());
//                    }
//                    catch (NumberFormatException e)
//                    {
//                        System.out.println("NumberFormatException: " + e.getMessage());
//                        Toast.makeText(RegisterActivity.this, "Please enter a number for HEIGHT",
//                                Toast.LENGTH_LONG).show();
//                    }
//                }


                password = txtPassword.getText().toString();
                rePass = txtConfirmPassword.getText().toString();

                RegisterManager registerManager = new RegisterManager(dbHelper);

                if (registerManager.registered(email, name, password, rePass, gender, age, weight, height)){ //if registration was successful
                    //create new user and if database is successfully added, go to login
                    newUser = new User(-1, name, email, age, weight, gender, height, password);
//                    DatabaseHelper dbHelper = new DatabaseHelper(RegisterActivity.this);

                    try{
                        dbHelper.addData(newUser);
                        Toast.makeText(RegisterActivity.this, "Registration Complete",
                                Toast.LENGTH_LONG).show();
                        Intent enterStats = new Intent(RegisterActivity.this,
                                LoginActivity.class);
                        startActivity(enterStats);
                    }catch(Exception e){
                        Toast.makeText(RegisterActivity.this, "Error: dbHelper.addData()",
                                Toast.LENGTH_LONG).show();
                    }


                }else{
                    Toast.makeText(RegisterActivity.this, registerManager.getRegErrorMessage(),
                            Toast.LENGTH_LONG).show();
                }

                //database and helper
//                DatabaseHelper dbHelper = new DatabaseHelper(RegisterActivity.this);

//                if (name.equals("") || password.equals("") || rePass.equals(""))
//                {
//                    Toast.makeText(RegisterActivity.this, "Please enter a user name and password",
//                            Toast.LENGTH_LONG).show();
//                }
//                else {
//                    if (dbHelper.checkName(name))
//                    {
//                        Toast.makeText(RegisterActivity.this, "User already exists!",
//                                Toast.LENGTH_LONG).show();
//                    }
//                    else if (password.equals(rePass))
//                    {
//                        //try to make a new user with all the data
//                        try
//                        {
//                            newUser = new User(-1, name, email, password);
//                        }
//                        //make a new user without any of their data entered
//                        catch (Exception e)
//                        {
//                            Toast.makeText(RegisterActivity.this, "Error in creating new user!",
//                                    Toast.LENGTH_LONG).show();
//                        }
//
//                        if (dbHelper.addData(newUser)) {
//
//                            Toast.makeText(RegisterActivity.this, "Registration Complete",
//                                    Toast.LENGTH_LONG).show();
//                            Intent enterStats = new Intent(RegisterActivity.this,
//                                    LoginActivity.class);
//                            startActivity(enterStats);
//                        }
//                        else
//                        {
//                            Toast.makeText(RegisterActivity.this, "Failed to add user to DB...",
//                                    Toast.LENGTH_LONG).show();
//                        }
//
//                    }
//                }
            }
        });//end registerSetOnClock

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioBtn_female:
                if (checked) {
                    gender = "female";
                }
                break;
            case R.id.radioBtn_male:
                if (checked){
                    gender = "male";
                }
                break;
        }
    }
}//end class