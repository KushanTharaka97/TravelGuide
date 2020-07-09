package com.example.android.travelguideme.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.android.travelguideme.data.CountryContract.InsertCountryData;

public class CountryDbHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "guide.db";
    private CountryDbHelper cDbHelper;


    public CountryDbHelper(Context context) {
        super(context, DATABASE_NAME,null,  DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            //creating database
            String SQL_CREATE_COUNTRY_TABLE = "CREATE TABLE "+ InsertCountryData.TABLE_NAME+ " ("
                    + InsertCountryData.COLUMN_COUNTRY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + InsertCountryData.COLUMN_COUNTRY_NAME + " TEXT NOT NULL, "
                    + InsertCountryData.COLUMN_COUNTRY_CURRENCY + " TEXT DEFAULT  Null , "
                    + InsertCountryData.COLUMN_COUNTRY_LANGUAGE + " TEXT DEFAULT Null , "
                    + InsertCountryData.COLUMN_COUNTRY_POPULATION + " INTEGER DEFAULT 0 , "
                    + InsertCountryData.COLUMN_COUNTRY_FAVOURITE + " INTEGER DEFAULT 0 , "
                    + InsertCountryData.COLUMN_COUNTRY_CAPITAL + " TEXT DEFAULT Null , "
                    + InsertCountryData.COLUMN_COUNTRY_CITY_01 + " TEXT DEFAULT Null , "
                    + InsertCountryData.COLUMN_COUNTRY_CITY_02 + " TEXT DEFAULT Null , "
                    + InsertCountryData.COLUMN_COUNTRY_CITY_03 + " TEXT DEFAULT Null , "
                    + InsertCountryData.COLUMN_COUNTRY_CITY_04 + " TEXT DEFAULT Null );";

            // Execute the SQL statement
            db.execSQL(SQL_CREATE_COUNTRY_TABLE);

            //inserting new data about countries
            String inserting_sql = "INSERT OR REPLACE INTO "+ InsertCountryData.TABLE_NAME
                    + "(" + InsertCountryData.COLUMN_COUNTRY_NAME
                    + "," + InsertCountryData.COLUMN_COUNTRY_CURRENCY + ","
                    + InsertCountryData.COLUMN_COUNTRY_POPULATION + ","
                    + InsertCountryData.COLUMN_COUNTRY_LANGUAGE + ","
                    + InsertCountryData.COLUMN_COUNTRY_CAPITAL + ","
                    + InsertCountryData.COLUMN_COUNTRY_CITY_01
                    + ") VALUES('New Zealand', 'AusDoller' , '1.5 Million','English','CapitalZealand','City one | city two | city three' )";

            //executing sql
            db.execSQL(inserting_sql);

        }catch (SQLException e){
            Log.e("Error Database","SQL Error has occured  ::" + e);
        }catch (ExceptionInInitializerError e){
            Log.e("Error Database","ExceptionInInitializerError  ::" + e);
        }catch (Exception e){
            Log.e("Error Occured","Error Occured in CountryDBHelper is :"+e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //insert data function
   /* private void insertDataTest(Context context){
       SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(InsertCountryData.COLUMN_COUNTRY_NAME, "Name 1");
        values.put(InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Language");
        values.put(InsertCountryData.COLUMN_COUNTRY_POPULATION, 55555);
        values.put(InsertCountryData.COLUMN_COUNTRY_CURRENCY, "type name");
        values.put(InsertCountryData.COLUMN_COUNTRY_CAPITAL, "capital");
        values.put(InsertCountryData.COLUMN_COUNTRY_CITIES, "more cities");

        ContentValues values01 = new ContentValues();
        values.put(InsertCountryData.COLUMN_COUNTRY_NAME, "France");
        values.put(InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "French");
        values.put(InsertCountryData.COLUMN_COUNTRY_POPULATION, 67);
        values.put(InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro");
        values.put(InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Paris");
        values.put(InsertCountryData.COLUMN_COUNTRY_CITIES, "Marseille,Lyon,Toulouse,Strasobourg,Bordeaux");

        ContentValues values02 = new ContentValues();
        values.put(InsertCountryData.COLUMN_COUNTRY_NAME, "Spain");
        values.put(InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Spanish");
        values.put(InsertCountryData.COLUMN_COUNTRY_POPULATION, 47);
        values.put(InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro");
        values.put(InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Madrid");
        values.put(InsertCountryData.COLUMN_COUNTRY_CITIES, "Barcelona,Seville, Granada,Valencia,Bilbao");

        ContentValues values03 = new ContentValues();
        values.put(InsertCountryData.COLUMN_COUNTRY_NAME, "China");
        values.put(InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Chinese");
        values.put(InsertCountryData.COLUMN_COUNTRY_POPULATION, 1430);
        values.put(InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Yuan");
        values.put(InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Beijing");
        values.put(InsertCountryData.COLUMN_COUNTRY_CITIES, "Hangzhou,Gullin,Chengdu,Guangzhou");

        //Inserting row
        Long rowId = db.insert(InsertCountryData.TABLE_NAME, null, values);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ InsertCountryData.COLUMN_COUNTRY_ID);
        //we used null because it is a new row

            //Toast.makeText(this, "Error inserting :", Toast.LENGTH_LONG).show();


        //connection close
        db.close();
    }*/
}
