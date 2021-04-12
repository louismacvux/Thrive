package com.comp3350.Database;

import java.io.File;
import java.sql.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;


public class DatabaseServices {

    static String createTable = "CREATE TABLE if not exists profiles ( " +
            " email VARCHAR(50), user_name VARCHAR(50), gender VARCHAR(50)," +
            " weight DOUBLE, age INTEGER, height DOUBLE, password VARCHAR(50) );";

        public static void setDB()
        {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:file:/data/data/com.example.comp3350/profilesdb;ifexists=false;shutdown=true", "SA", "");
            Statement stmt = con.createStatement();

            stmt.executeUpdate(createTable);

            con.close();
            stmt.close();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.out.println("Error in creating database");
            e.printStackTrace(System.out);
        }
    }
}
