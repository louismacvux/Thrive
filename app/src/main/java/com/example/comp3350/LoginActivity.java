package com.example.comp3350;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.comp3350.R;

public class LoginActivity extends AppCompatActivity {

    //set variables that are captured on welcome page
    EditText txtUsername;
    EditText txtPassword;

    String userName;

    Button buttonLogin;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = (EditText) findViewById(R.id.edittext_username);
        txtPassword = (EditText) findViewById(R.id.edittext_password);
        buttonLogin = (Button) findViewById(R.id.button_login);
        signUp = (Button) findViewById(R.id.button_register);

        userName = txtUsername.getText().toString();

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
                User currentUser = dbHelper.getSomeone(userName);

                if (currentUser.getId() > 0) {
                    Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(MainIntent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "No such user, tap 'REGISTER'",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}