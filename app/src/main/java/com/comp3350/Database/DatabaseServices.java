package com.comp3350.Database;

<<<<<<< Updated upstream
import java.sql.*;


public class DatabaseServices {

    String createTable = "CREATE TABLE if not exists profiles ( ID INTEGER identity," +
            " email VARCHAR(50), user_name VARCHAR(50), gender VARCHAR(50)," +
            " weight DOUBLE, age INTEGER, height DOUBLE, password VARCHAR(50) );";


        private static String dbName="profiles";

        public static void setDBPathName(final String name)
        {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;
    }

        public static String getDBPathName() {
        return dbName;
=======
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

>>>>>>> Stashed changes
    }
}
