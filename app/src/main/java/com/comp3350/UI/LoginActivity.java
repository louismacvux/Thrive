package com.comp3350.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Logic.LoginManager;
import com.comp3350.R;

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

        db = new DatabaseHelper(this);

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

                userName = txtUsername.getText().toString();
                userPass = txtPassword.getText().toString();

                if (userName.equals("") || userPass.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Please enter both username and password",
                            Toast.LENGTH_LONG).show();
                }
                else {
//                    boolean checkUserPass = loginManager.proceedLogin(userName, userPass);
                    if (loginManager.proceedLogin(userName, userPass)) {
                        Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
                        MainIntent.putExtra("currentUser", userName);
                        startActivity(MainIntent);
                    } else if (loginManager.foundUser(userName)) {
                        Toast.makeText(LoginActivity.this, "Incorrect Password",
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"No such user... SIGN UP!",
                                Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }

//    public boolean fieldEmpty(String username, String userpass){
//        boolean result = true;
//        if (username.isEmpty()){
//            Toast.makeText(LoginActivity.this, "Please enter your username",
//                            Toast.LENGTH_LONG).show();
//            result = false;
//        }
//        if (userpass.isEmpty()){
//            Toast.makeText(LoginActivity.this, "Please enter your password",
//                    Toast.LENGTH_LONG).show();
//            result = false;
//        }
//        return result;
//    }//end fieldEmpty
}//end class