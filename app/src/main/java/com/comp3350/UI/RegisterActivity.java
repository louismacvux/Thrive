package com.comp3350.UI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Database.DatabaseServices;
import com.comp3350.R;
import com.comp3350.Logic.RegisterManager;

public class RegisterActivity extends AppCompatActivity {

    //set variables that are captured on registration page
    private EditText txtEmail, txtUsername, txtPassword, txtConfirmPassword;
    private EditText txtAge, txtWeight, txtHeight;
    Button register;
    RadioGroup txtGender;

    //variables used to create our User object
    private String email;
    private String name;
    private String password;
    private String rePass;
    private String gender;
    private int age, checkGender;
    private double weight;
    private double height;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper();

        txtEmail = findViewById(R.id.edittext_useremail);
        txtUsername = findViewById(R.id.edittext_username);
        txtPassword = findViewById(R.id.edittext_password);
        txtConfirmPassword = findViewById(R.id.edittext_confrim_password);
        txtAge = findViewById(R.id.edittext_age);
        txtWeight = findViewById(R.id.edittext_weight);
        txtHeight = findViewById(R.id.edittext_height);
        txtGender = (RadioGroup)findViewById(R.id.radioGroup_gender);

        register = findViewById(R.id.button_done_register);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                email = txtEmail.getText().toString();
                name = txtUsername.getText().toString();
                password = txtPassword.getText().toString();
                rePass = txtConfirmPassword.getText().toString();
                checkGender = txtGender.getCheckedRadioButtonId();
                age = 0;
                weight = 0;
                height = 0;

                if (checkGender == -1)
                {
                    Toast.makeText(com.comp3350.UI.RegisterActivity.this, "Please indicate a gender",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    switch (checkGender)
                    {
                        case R.id.radioBtn_female:
                            gender = "Female";
                            break;

                        case R.id.radioBtn_male:
                            gender = "Male";
                            break;
                    }
                }
                //validate AGE
                if (!txtAge.getText().toString().equals("")) {
                    //try to get numeric values from age, weight and height
                    try {
                        age = Integer.parseInt(txtAge.getText().toString());
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException: " + e.getMessage());
                        Toast.makeText(RegisterActivity.this, "Please enter a number for AGE",
                                Toast.LENGTH_LONG).show();
                    }
                }
                //validate WEIGHT
                if (!txtWeight.getText().toString().equals("")) {
                    try {
                        weight = Double.parseDouble(txtWeight.getText().toString());
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException: " + e.getMessage());
                        Toast.makeText(RegisterActivity.this, "Please enter a number for WEIGHT",
                                Toast.LENGTH_LONG).show();
                    }
                }

                //validate HEIGHT
                if (!txtHeight.getText().toString().equals("")) {
                    try {
                        height = Double.parseDouble(txtHeight.getText().toString());
                    } catch (NumberFormatException e) {
                        System.out.println("NumberFormatException: " + e.getMessage());
                        Toast.makeText(RegisterActivity.this, "Please enter a number for HEIGHT",
                                Toast.LENGTH_LONG).show();
                    }
                }

                RegisterManager registerManager = new RegisterManager(db);

                if (registerManager.registered(email, name, password, rePass, gender, age, weight, height)){ //if registration was successful
                    //create new user and if database is successfully added, go to login

                    Toast.makeText(RegisterActivity.this, "Registration Complete",
                            Toast.LENGTH_LONG).show();
                    Intent enterStats = new Intent(RegisterActivity.this,
                            LoginActivity.class);
                    startActivity(enterStats);

                }else{
                    Toast.makeText(RegisterActivity.this, registerManager.getRegErrorMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });//end registerSetOnClock
    }

    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioBtn_female:
                if (checked) {
                    gender = "Female";
                }
                break;
            case R.id.radioBtn_male:
                if (checked){
                    gender = "Male";
                }
                break;
        }
    }
}//end class