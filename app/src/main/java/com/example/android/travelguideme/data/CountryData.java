package com.example.android.travelguideme.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CountryData {
    CountryDbHelper mDbHelper;

    //insert data function
    private void insertData(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Name 1");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Language");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 55555);
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "type name");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "capital");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITIES, "more cities");

        ContentValues values01 = new ContentValues();
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "France");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "French");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 67);
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Paris");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITIES, "Marseille,Lyon,Toulouse,Strasobourg,Bordeaux");

        ContentValues values02 = new ContentValues();
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Spain");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Spanish");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 47);
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Madrid");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITIES, "Barcelona,Seville, Granada,Valencia,Bilbao");

        ContentValues values03 = new ContentValues();
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "China");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Chinese");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 1430);
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Yuan");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Beijing");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITIES, "Hangzhou,Gullin,Chengdu,Guangzhou");


        ContentValues values04 = new ContentValues();
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Spain");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Spanish");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 47);
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Madrid");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITIES, "Barcelona,Seville, Granada,Valencia,Bilbao");

        ContentValues values05 = new ContentValues();
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "China");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Chinese");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 1430);
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Yuan");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Beijing");
        values.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITIES, "Hangzhou,Gullin,Chengdu,Guangzhou");

        //Inserting row
        Long rowId = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);
        //we used null because it is a new row

        //Toast.makeText(this, "Error inserting :", Toast.LENGTH_LONG).show();


        //connection close
        db.close();
    }
}
