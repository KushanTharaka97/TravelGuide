package com.example.android.travelguideme.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.travelguideme.data.CountryContract.InsertCountryData;

public class CountryDbHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "guide.db";
    private CountryDbHelper cDbHelper;


    public CountryDbHelper(Context context) {
        super(context, DATABASE_NAME,null,  DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating database
        String SQL_CREATE_COUNTRY_TABLE = "CREATE TABLE "+ InsertCountryData.TABLE_NAME+ " ("
                + InsertCountryData.COLUMN_COUNTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + InsertCountryData.COLUMN_COUNTRY_NAME + " TEXT NOT NULL, "
                + InsertCountryData.COLUMN_COUNTRY_CURRENCY + " TEXT DEFAULT  Null , "
                + InsertCountryData.COLUMN_COUNTRY_LANGUAGE + " TEXT DEFAULT Null , "
                + InsertCountryData.COLUMN_COUNTRY_POPULATION + " INTEGER DEFAULT 0 , "
                + InsertCountryData.COLUMN_COUNTRY_CAPITAL + " TEXT DEFAULT Null , "
                + InsertCountryData.COLUMN_COUNTRY_CITIES + " TEXT DEFAULT Null );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_COUNTRY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //insert data function
    private void insertData(Context context){
       SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(InsertCountryData.COLUMN_COUNTRY_NAME, "Name 1");
        values.put(InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Language");
        values.put(InsertCountryData.COLUMN_COUNTRY_POPULATION, 55555);
        values.put(InsertCountryData.COLUMN_COUNTRY_CURRENCY, "type name");
        values.put(InsertCountryData.COLUMN_COUNTRY_CAPITAL, "capital");
        values.put(InsertCountryData.COLUMN_COUNTRY_CITIES, "more cities");

        //Inserting row
        Long rowId = db.insert(InsertCountryData.TABLE_NAME, null, values);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ InsertCountryData.COLUMN_COUNTRY_ID);
        //we used null because it is a new row

            //Toast.makeText(this, "Error inserting :", Toast.LENGTH_LONG).show();


        //connection close
        db.close();
    }
}
