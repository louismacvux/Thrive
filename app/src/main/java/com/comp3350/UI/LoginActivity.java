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
<<<<<<< Updated upstream
        copyDatabaseToDevice();
        DatabaseHelper db = new DatabaseHelper(DatabaseServices.getDBPathName());
=======
        DatabaseServices.setDB();
        DatabaseHelper db = new DatabaseHelper();
>>>>>>> Stashed changes

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

                if (userName.isEmpty() || userPass.isEmpty())
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
                    } else {
                        Toast.makeText(LoginActivity.this,"No such user... SIGN UP!",
                                Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
<<<<<<< Updated upstream
    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            DatabaseServices.setDBPathName(dataDirectory.toString() + "/" + DatabaseServices.getDBPathName());

        } catch (final IOException ioe) {
            System.out.println("Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
=======
>>>>>>> Stashed changes
    }
}//end class