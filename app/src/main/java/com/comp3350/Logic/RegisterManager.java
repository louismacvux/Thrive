package com.comp3350.Logic;
import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Object.User;


public class RegisterManager{

    private DatabaseHelper dbHelper = null;
    private String registerErrorMessage = "";

    public RegisterManager(DatabaseHelper dbHelper){
        this.dbHelper = dbHelper;
    }
    public RegisterManager(){  }

    //This will return true when user is registered successfully and add the user
    //if all the fields are entered, password matches, and the user is a new user
    public boolean registered(String email, String username, String pw, String confirmPw, String gender, int age, double weight, double height){
        boolean result = false;

        if (!fieldEmpty(email, username, pw, confirmPw, gender, age, weight, height) && (validateName(username) && validatePass(pw)
        && validateEmail(email))){
            if (pwMatches(pw, confirmPw)){
                if (!userExists(username)){
                    User newUser = new User(username, email, age, weight, gender, height, pw);
                    dbHelper.addData(newUser);
                    result = true;
                }
            }else{
                registerErrorMessage += "Your confirmation password is different from your desired password\n";
            }
        }

        return result;
    }//end registered

    public boolean fieldEmpty(String email, String username, String pw, String confirmPw, String gender, int age, double weight, double height){
        boolean result = false;
        if (email.equals("")){
            registerErrorMessage += "Please enter your email\n";
            result = true;
        }
        if (username.equals("")){
            registerErrorMessage += "Please enter your username\n";
            result = true;
        }
        if (pw.equals("")){
            registerErrorMessage += "Please enter your password\n";
            result = true;
        }
        if (confirmPw.equals("")){
            registerErrorMessage += "Please enter your confirmation password\n";
            result = true;
        }
        if (age == 0){
            registerErrorMessage += "Please enter your age\n";
            result = true;
        }
        if (weight == 0){
            registerErrorMessage += "Please enter your weight in lbs\n";
            result = true;
        }
        if (height == 0){
            registerErrorMessage += "Please enter your height in cm\n";
            result = true;
        }
        return result;
    }//end fieldEmpty

    public boolean userExists(String username){
        return dbHelper.checkName(username);
    }//end userExists

    public boolean pwMatches(String pw, String confirmPw){
        return pw.equals(confirmPw);
    }//end pwMatches

    public boolean validateEmail(String email)
    {
        boolean result = false;
        String givenName = email.trim();
        String whiteSpace = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (givenName.isEmpty())
        {
            registerErrorMessage += "Email cannot be empty\n";
        }
        else if (givenName.length() > 40)
        {
            registerErrorMessage += "Email must be less than 40 characters\n";
        }
        else if (!givenName.matches(whiteSpace))
        {
            registerErrorMessage += "Email must be formatted as abc@efg.com\n";
        }
        else
        {
            result = true;
        }
        return result;
    }

    public boolean validateName(String name)
    {
        boolean result = false;
        String givenName = name.trim();
        String whiteSpace = "\\A\\w{1,20}\\z";

        if (givenName.isEmpty())
        {
            registerErrorMessage += "User name cannot be empty\n";
        }
        else if (givenName.length() > 20)
        {
            registerErrorMessage += "User name must be less than 20 characters...\n";
        }
        else if (!givenName.matches(whiteSpace))
        {
            registerErrorMessage += "User name cannot have blank spaces...\n";
        }
        else
        {
            result = true;
        }
        return result;
    }

    public boolean validatePass(String password)
    {
        boolean result = false;
        String givenName = password.trim();
        String whiteSpace = "\\A\\w{1,20}\\z";

        if (givenName.isEmpty())
        {
            registerErrorMessage += "PASSWORD cannot be empty...\n";
        }
        else if (givenName.length() > 20)
        {
            registerErrorMessage += "PASSWORD must be less than 20 characters...\n";
        }
        else if (!givenName.matches(whiteSpace))
        {
            registerErrorMessage += "PASSWORD cannot have blank spaces...\n";
        }
        else
        {
            result = true;
        }
        return result;
    }

    public String getRegErrorMessage(){
        return registerErrorMessage;
    }//end registerErrorMessage
}//end class
