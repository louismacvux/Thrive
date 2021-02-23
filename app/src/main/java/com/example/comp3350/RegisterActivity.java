package com.example.comp3350;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    Button register;
    String name;
    String email;

    //SharedPreferences sp = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userEmail = (EditText)findViewById(R.id.edittext_useremail);
        txtUsername = (EditText)findViewById(R.id.edittext_username);
        txtPassword = (EditText)findViewById(R.id.edittext_password);
        confirmPassword = (EditText)findViewById(R.id.edittext_confrim_password);
        register = (Button)findViewById(R.id.button_done_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //name = txtUsername.getText().toString();
               // email = userEmail.getText().toString();

                //SharedPreferences.Editor editor = sp.edit();

                //editor.putString("name", name);
                //editor.putString("email", email);
                //editor.commit();
                Toast.makeText(RegisterActivity.this, "Registration Complete!",
                        Toast.LENGTH_LONG).show();

                Intent loginIntent = new Intent(RegisterActivity.this,
                        LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}