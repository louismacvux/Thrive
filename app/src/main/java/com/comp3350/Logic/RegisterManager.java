package com.comp3350.Logic;
import android.widget.Toast;

import com.comp3350.Database.DatabaseHelper;
import com.comp3350.Object.User;
import com.comp3350.UI.RegisterActivity;


public class RegisterManager{

    private DatabaseHelper dbHelper = null;
    private String registerErrorMessage = "";

    public RegisterManager(DatabaseHelper dbHelper){
        this.dbHelper = dbHelper;
    }
    public RegisterManager(){  }

    //This will return true when user is registered successfully and add the user
    //if all the fields are entered, password matches, and the user is a new user
    public boolean registered(String email, String username, String pw, String confirmPw, String gender, int genderRadioBtn, String string_age, String string_weight, String string_height){
        boolean result = false;
        registerErrorMessage = "";
        //separate each booleans instead of return together because it is necessary for concatenating error message
        boolean validate_name = validateName(username);
        boolean validate_email = validateEmail(email);
        boolean validate_pass = validatePass(pw);
        boolean validate_confirmPw = validateConfirmPass(pw, confirmPw);
        boolean genderClicked = radioBtnClicked(genderRadioBtn, "gender");
        int age = parseInt(string_age, "age");
        double weight = parseDouble(string_weight, "weight");
        double height = parseDouble(string_height, "height");

        if (validate_name && validate_email && validate_pass && validate_confirmPw && genderClicked && !(age <= 0) && !(weight <= 0) && !(height <= 0)){
            if (!userExists(username)){
                User newUser = new User(username, email, age, weight, gender, height, pw);
                dbHelper.addData(newUser);
                result = true;
            }
        }

        return result;
    }//end registered

    public int parseInt(String num, String fieldName) {
        int result = -1;
        if(!num.isEmpty()) {
            try {
                result = Integer.parseInt(num);
            }
            catch (NumberFormatException e) {
                System.out.println("NumberFormatException: " + e.getMessage());
                registerErrorMessage += "Please enter a correct value for " + fieldName +"\n";
            }
        }
        if(result <= 0) {
            registerErrorMessage += "Please enter your " + fieldName +"\n";
        }
        return result;
    }//end parseInt

    public double parseDouble(String num, String fieldName) {
        double result = -1;
        if(!num.isEmpty()) {
            try {
                result = Double.parseDouble(num);
            }
            catch (NumberFormatException e) {
                System.out.println("NumberFormatException: " + e.getMessage());
                registerErrorMessage += "Please enter a correct value for " + fieldName +"\n";
            }
        }
        if(result <= 0) {
            registerErrorMessage += "Please enter your " + fieldName +"\n";
        }
        return result;
    }//end parseDouble

    public boolean radioBtnClicked(int radioBtn, String buttonName){
        if(radioBtn != -1) {
            return true;
        }
        else {
            registerErrorMessage += "Please indicate your " + buttonName +"\n";
            return false;
        }
    }

    public boolean userExists(String username){
        if(dbHelper.checkName(username)) {
            registerErrorMessage += "User already existed, please choose other username\n";
            return true;
        }
        else {
            return false;
        }
    }//end userExists

    public boolean validateEmail(String email)
    {
        boolean result = false;
        String input = email.trim();
        String email_format = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (input.isEmpty())
        {
            registerErrorMessage += "Please enter your email\n";
        }
        else if (input.length() > 40)
        {
            registerErrorMessage += "Email must be less than 40 characters\n";
        }
        else if (!input.matches(email_format))
        {
            registerErrorMessage += "Email must be formatted as abc@efg.com\n";
        }
        else
        {
            result = true;
        }
        return result;
    }//end validateEmail

    public boolean validateName(String name)
    {
        boolean result = false;
        String input = name.trim();
        String whiteSpace = "\\A\\w{1,20}\\z";

        if (input.isEmpty())
        {
            registerErrorMessage += "Please enter your username\n";
        }
        else if (input.length() > 20)
        {
            registerErrorMessage += "Username must be less than 20 characters...\n";
        }
        else if (!input.matches(whiteSpace))
        {
            registerErrorMessage += "Username cannot have blank spaces...\n";
        }
        else
        {
            result = true;
        }
        return result;
    }//end validateName

    public boolean validatePass(String password)
    {
        boolean result = false;
        String input = password.trim();
        String whiteSpace = "\\A\\w{1,30}\\z";

        if (input.isEmpty())
        {
            registerErrorMessage += "Please enter your password\n";
        }
        else if (input.length() > 30)
        {
            registerErrorMessage += "Password must be less than 30 characters...\n";
        }
        else if (input.length() < 6)
        {
            registerErrorMessage += "Password must be more than 6 characters...\n";
        }
        else if (!input.matches(whiteSpace))
        {
            registerErrorMessage += "Password cannot have blank spaces...\n";
        }
        else
        {
            result = true;
        }
        return result;
    }//end validatePass

    public boolean validateConfirmPass(String password, String confirmPassword){
        if(password.equals(confirmPassword)) {
            if(confirmPassword.isEmpty()) {
                registerErrorMessage += "Please enter your confirmation password\n";
            }
            return true;
        }
        else {
            if(confirmPassword.isEmpty()) {
                registerErrorMessage += "Please enter your confirmation password\n";
            }
            else {
                registerErrorMessage += "Your confirmation password is different from your desired password\n";
            }
            return false;
        }
    }//end validateConfirmPass

    public String getRegErrorMessage(){
        return registerErrorMessage;
    }//end registerErrorMessage
}//end class
