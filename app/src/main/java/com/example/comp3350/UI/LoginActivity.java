package com.example.comp3350.UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comp3350.Database.DatabaseHelper;
import com.example.comp3350.Logic.LoginManager;
import com.example.comp3350.R;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsername, txtPassword;

    //Strings to work with EditText variables
    private String userName, userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //get the data from the GUI
        txtUsername = findViewById(R.id.edittext_username);
        txtPassword = findViewById(R.id.edittext_password);
        Button buttonLogin = findViewById(R.id.button_login);
        Button signUp = findViewById(R.id.button_register);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dbHelper = new DatabaseHelper(LoginActivity.this);
                LoginManager loginManager = new LoginManager(dbHelper);

                userName = txtUsername.getText().toString();
                userPass = txtPassword.getText().toString();

                if (!fieldEmpty(userName, userPass)){
                    if (loginManager.loginSuccess(userName, userPass)){//login Success
                        //move to mainActivity
                        Intent mainActivity = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(mainActivity);
                    }else{
                        Toast.makeText(LoginActivity.this, loginManager.getLoginErrorMessage(), Toast.LENGTH_LONG).show();
                    }
                }


//                if (userName.equals("") || userPass.equals(""))
//                {
//                    Toast.makeText(LoginActivity.this, "Please enter both username and password",
//                            Toast.LENGTH_LONG).show();
//                }
//                else {
//                    boolean checkUserPass = dbHelper.checkCredentials(userName, userPass);
//                    if (checkUserPass == true) {
//                        Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
//                        MainIntent.putExtra("currentUser", userName);
//                        startActivity(MainIntent);
//                    } else if (dbHelper.checkName(userName)) {
//                        Toast.makeText(LoginActivity.this, "Incorrect Password",
//                                Toast.LENGTH_LONG).show();
//                    }
//                    else
//                    {
//                        Toast.makeText(LoginActivity.this, "No such user... SIGN UP!",
//                                Toast.LENGTH_LONG).show();
//                    }
//                }
            }
        });
    }

    public boolean fieldEmpty(String username, String userpass){
        boolean result = true;
        if (username.isEmpty()){
            Toast.makeText(LoginActivity.this, "Please enter your username",
                            Toast.LENGTH_LONG).show();
            result = false;
        }
        if (userpass.isEmpty()){
            Toast.makeText(LoginActivity.this, "Please enter your password",
                    Toast.LENGTH_LONG).show();
            result = false;
        }
        return result;
    }//end fieldEmpty
}//end class