package com.comp3350.UI;
import com.comp3350.Database.DatabaseServices;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Logic.LoginManager;
import com.comp3350.R;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsername, txtPassword;
    private Button login, signUp;

    //Strings to work with EditText variables
    private String userName, userPass;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DatabaseServices.setDB();
        DatabaseHelper db = new DatabaseHelper();

        //get the data from the GUI
        txtUsername = (EditText) findViewById(R.id.edittext_username);
        txtPassword = (EditText) findViewById(R.id.edittext_password);
        login = (Button) findViewById(R.id.button_login);
        signUp = (Button) findViewById(R.id.button_register);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, com.comp3350.UI.RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager loginManager = new LoginManager(db);
                String toast;

                toast = loginManager.validateUser(txtUsername.getText().toString(), txtPassword.getText().toString());
                Toast.makeText(LoginActivity.this,toast,Toast.LENGTH_LONG).show();
                if (toast == "Successfully logged in"){
                    Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    MainIntent.putExtra("currentUser", userName);
                    startActivity(MainIntent);
                }
            }
        });
    }
}//end class