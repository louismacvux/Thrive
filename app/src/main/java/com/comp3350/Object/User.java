package com.comp3350.Object;
import com.comp3350.Database.DatabaseHelper;


public class User {
    private String name;
    private String email;
    private int age;
    private double weight;
    private String gender;
    private double height;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                '}';
    }

    public User (String name, String email, int age, double weight, String gender, double height, String password)
    {
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.height = height;
        this.password = password;
    }
    public User(){}

    public void setName(String name,  DatabaseHelper db) {
        this.name = name;
        db.updateInfo(name, "COL_NAME", name);
    }

    public void setEmail(String email,  DatabaseHelper db) {
        this.email = email;
        db.updateInfo(name, "COL_EMAIL", email);
    }

    public void setAge(int age, DatabaseHelper db) {
        this.age = age;
        db.updateInfo(name, "COL_AGE", String.valueOf(age));
    }

    public void setWeight(double weight, DatabaseHelper db) {
        this.weight = weight;
        db.updateInfo(name, "COL_WEIGHT", String.valueOf(weight));
    }

    public void setGender(String gender, DatabaseHelper db) {
        this.gender = gender;
        db.updateInfo(name, "COL_GENDER", gender);
    }

    public void setHeight(double height, DatabaseHelper db) {
        this.height = height;
        db.updateInfo(name, "COL_HEIGHT", String.valueOf(height));
    }

    public void setPassword(String password, DatabaseHelper db) { this.password = password;
        db.updateInfo(name, "COL_PW", password);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public int  getGenderInt() {
        if (gender.equalsIgnoreCase("Male"))
        {
            return 0;
        }
        else if (gender.equalsIgnoreCase("Female"))
        {
            return 1;
        }
        else{
            return -1;
        }
    }

    public double getHeight() {
        return height;
    }

    public String getPassword() { return password;}

}
