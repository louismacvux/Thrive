package com.comp3350.Database;

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
    }
}
