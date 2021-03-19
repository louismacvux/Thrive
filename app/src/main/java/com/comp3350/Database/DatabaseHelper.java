package com.comp3350.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.comp3350.Logic.RegisterManager;
import com.comp3350.Object.User;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private static final String TAG = "DatabaseHelper";

    private static final String FILE_NAME = "users.db";
    private static final String TABLE_NAME = "profiles";
    private static final String COL_ID = "ID";
    private static final String COL_EMAIL = "email";
    private static final String COL_USERNAME = "user_name";
    private static final String COL_GENDER = "gender";
    private static final String COL_WEIGHT = "weight";
    private static final String COL_AGE = "age";
    private static final String COL_HEIGHT = "height";
    private static final String COL_PW = "password";


    public DatabaseHelper (Context context)
    {
        super(context, FILE_NAME, null, 1);
    }

    //this will only process when we create a new database
    @Override
    public void onCreate(SQLiteDatabase db)
    {
       String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_EMAIL + " TEXT, " +
               COL_USERNAME + " TEXT, " + COL_GENDER + " TEXT, " + COL_WEIGHT + " DOUBLE, " +
               COL_AGE + " INTEGER, " + COL_HEIGHT + " DOUBLE, " + COL_PW + " TEXT) ";
        db.execSQL(createTable);
    }

    //this runs only when we update the version of the application
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(User newUser)
    {
        //assume we didn't add data(item) to the table
        boolean result = false;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //insert user data in database file
        contentValues.put(COL_EMAIL, newUser.getEmail());
        contentValues.put(COL_USERNAME, newUser.getName());
        contentValues.put(COL_GENDER, newUser.getGender());
        contentValues.put(COL_WEIGHT, newUser.getWeight());
        contentValues.put(COL_AGE, newUser.getAge());
        contentValues.put(COL_HEIGHT, newUser.getHeight());
        contentValues.put(COL_PW, newUser.getPassword());

        Log.d(TAG, "addData: Adding a new user to " + TABLE_NAME);

        // -1 if not inserted, otherwise it was inserted
        long check = db.insert(TABLE_NAME, null, contentValues);
        db.close();

        if (check  != -1)
        {
            result = true;
        }
        return result;
    }

    public User getSomeone(String name)
    {
        User result;

        //Query the database to pull a user
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_USERNAME + " = ?", new String[] {name});

        //if we found our user
        if (cursor.moveToFirst())
        {
            int userID = cursor.getInt(0);
            String userEmail = cursor.getString(1);
            String userName = cursor.getString(2);
            String userGender = cursor.getString(3);
            double userWeight = cursor.getDouble(4);
            int userAge = cursor.getInt(5);
            double userHeight = cursor.getDouble(6);
            String userPass = cursor.getString(7);

            result = new User(userID, userName, userEmail, userAge, userWeight, userGender, userHeight, userPass);
        }
        //empty User
        else
        {
            result = null;
        }
        //close db and cursor when done
        db.close();
        cursor.close();
        return result;
    }

    public boolean checkCredentials(String givenName, String givenPassword)
    {
        boolean result = false;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE " + COL_USERNAME + " = ? AND " + COL_PW + " = ?", new String[] {givenName, givenPassword});

        cursor.moveToFirst();
        String help = DatabaseUtils.dumpCursorToString(cursor);
        Log.d(TAG, help);
        if (cursor.getCount() > 0)
        {
            result = true;
        }
        return result;
    }

    //returns true if there is a same username found
    public boolean checkName(String givenName)
    {
        boolean result = false;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME +
                " WHERE " +  COL_USERNAME + " = ?", new String[] {givenName});

        cursor.moveToFirst();
        String help = DatabaseUtils.dumpCursorToString(cursor);
        Log.d(TAG, help);

        if (cursor.getCount() > 0)
        {
            result = true;
        }
        return result;
    }

    public boolean updateInfo(String id, String column, String data)
    {
        boolean result = false;

        //parse the string to an 'int' if necessary
        SQLiteDatabase db = this.getWritableDatabase();
        try
        {
            Integer.parseInt(data);
        }
        catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
        }

        //CV object is used to add/update our DB
        ContentValues contentValues = new ContentValues();
        contentValues.put(column, data);

        //checker -> will be the number of rows affected
        int checker = db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id} );

        if (checker > 0)
        {
            result = true;
        }
        return result;
    }

    public boolean deleteUser(String name)
    {
        //assume we didn't remove the user from the db
        boolean result = false;

        //Query the database to pull a user
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        cursor = db.rawQuery("DELETE FROM " + TABLE_NAME + " WHERE " + COL_USERNAME + " = ?", new String[] {name});

        if (!checkName(name))
        {
            result = true;
        }
        return result;
    }
}//end class
