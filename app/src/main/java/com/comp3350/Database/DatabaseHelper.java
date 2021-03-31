package com.comp3350.Database;
import java.sql.*;
import com.comp3350.Database.DatabaseServices;


import com.comp3350.Object.User;

public class DatabaseHelper implements Database
{

    private static final String TABLE_NAME = "profiles";
    private static final String COL_EMAIL = "email";
    private static final String COL_USERNAME = "user_name";
    private static final String COL_GENDER = "gender";
    private static final String COL_WEIGHT = "weight";
    private static final String COL_AGE = "age";
    private static final String COL_HEIGHT = "height";
    private static final String COL_PW = "password";


    public DatabaseHelper (){
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:/data/data/com.example.comp3350/profilesdb;ifexists=false;shutdown=true", "SA", "");
    }



    public boolean addData(User newUser)
    {
        //assume we didn't add a new user to the table
        boolean result = false;

        System.out.println(newUser.toString());
        try (Connection con = connection())
        {
            PreparedStatement pstmt = con.prepareStatement(
                    "insert into profiles (" + COL_EMAIL + ", "  + COL_USERNAME + ", " +
                            COL_GENDER + ", "  + COL_WEIGHT + ", "  + COL_AGE + ", " +
                            COL_HEIGHT + ", " +  COL_PW + ") values (?, ?, ?, ?, ?, ?, ?);");

            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getName());
            pstmt.setString(3, newUser.getGender());
            pstmt.setDouble(4, newUser.getWeight());
            pstmt.setInt(5, newUser.getAge());
            pstmt.setDouble(6, newUser.getHeight());
            pstmt.setString(7, newUser.getPassword());

            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (SQLException e) {
            System.out.println("Error in adding a new user...");
            e.printStackTrace(System.out);
        }

        User checker = getSomeone(newUser.getName());

        if (checker != null)
        {
            result = true;
        }
        return result;
    }

    public User getSomeone(String name) {
        User result = null;

        try (Connection con = connection())
        {
            PreparedStatement pstmt = con.prepareStatement(
                    "Select * From " + TABLE_NAME + " where " + COL_USERNAME + " = ?;"
            );
            pstmt.setString(1, name);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next())
            {
                // at least 1 row (hopefully one row!) exists. Get the data
                result = new User(resultSet.getString(COL_USERNAME), resultSet.getString(COL_EMAIL),
                        resultSet.getInt(COL_AGE), resultSet.getDouble(COL_WEIGHT), resultSet.getString(COL_GENDER),
                        resultSet.getDouble(COL_HEIGHT), resultSet.getString(COL_PW));

            }
            pstmt.close();
            resultSet.close();
        }
        catch (SQLException e) {
            System.out.println("Error in finding user: " + name);
            e.printStackTrace(System.out);
        }

        return result;
    }


    public boolean checkCredentials(String givenName, String givenPassword)
    {
        boolean result = false;

        try (Connection con = connection())
        {
            PreparedStatement pstmt = con.prepareStatement(
                    "Select " + COL_PW + " from " + TABLE_NAME + " where "+ COL_PW +
                            "  = ?;");
            pstmt.setString(1, givenPassword);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next() && checkName(givenName))
            {
                result = true;
            }
            pstmt.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }
        return result;
    }

    //returns true if there is a same username found
    public boolean checkName(String givenName)
    {
        boolean result = false;

        try (Connection con = connection())
        {
            PreparedStatement pstmt = con.prepareStatement(
                    "Select " + COL_USERNAME + " from " + TABLE_NAME + " where "+ COL_USERNAME +
                            "  = ?;");
            pstmt.setString(1, givenName);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next())
            {
                result = true;
            }
            pstmt.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }
        return result;
    }

    public boolean updateInfo(String name, String column, String data)
    {
        boolean result = false;

        //parse the string to an 'int' if necessary, for AGE
        if (column.equals(COL_AGE))
        {
            try
            {
                Integer.parseInt(data);
            }
            catch (NumberFormatException e)
            {
                System.out.println(e.getMessage());
            }
        }

        //parse the string to an 'int' if necessary, for AGE
        if (column.equals(COL_HEIGHT)|| column.equals(COL_WEIGHT))
        {
            try
            {
                Double.parseDouble(data);
            }
            catch (NumberFormatException e)
            {
                System.out.println(e.getMessage());
            }
        }

        try (Connection con = connection())
        {
            PreparedStatement pstmt = con.prepareStatement(
                    "Select " + COL_USERNAME + " from " + TABLE_NAME + " where "+ COL_USERNAME +
                            "  = ?;");

            pstmt.setString(1, name);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next())
            {
                pstmt = con.prepareStatement(
                        "Update " + TABLE_NAME + " set " + column + " = " + data + "  where " + COL_USERNAME +
                                "  = ?;");
                pstmt.setString(1, name);
                result = true;
            }
            pstmt.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace(System.out);
        }
        return result;
    }

    public boolean removeUser(User user)
    {
        //assume we didn't remove the user from the db
        boolean result = false;

        if (!checkName(user.getName()))
        {
            result = true;
        }
        return result;
    }
}//end class
