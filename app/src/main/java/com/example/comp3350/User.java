package com.example.comp3350;

public class User {
    private int id;
    private String name;
    private String email;
    private int age;
    private int weight;
    private String gender;
    private double height;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                '}';
    }

    public User (int id, String name, String email, int age, int weight, String gender,
                 double height, String password)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.height = height;
        this.password = password;
    }
    public User(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setheight(int height) {
        this.height = height;
    }

    public void setPassword(String password) { this.password = password;}

    public int getId() {
        return id;
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

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    public int  getGenderInt() {
        if (gender.equalsIgnoreCase("male"))
        {
            return 0;
        }
        else if (gender.equalsIgnoreCase("female"))
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
