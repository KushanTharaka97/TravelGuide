package com.example.android.travelguideme.data;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import com.example.android.travelguideme.data.CountryContract.InsertCountryData;

public class CountryData {
    //create olect from DBHelper class
    CountryDbHelper mDbHelper;
    SQLiteDatabase db;

    //insert data function
    public void insertData(){
/*
        //projection method for show
        String[] projection = {
                InsertCountryData.COLUMN_COUNTRY_NAME,
                InsertCountryData.COLUMN_COUNTRY_LANGUAGE,
                InsertCountryData.COLUMN_COUNTRY_POPULATION,
                InsertCountryData.COLUMN_COUNTRY_CURRENCY,
                InsertCountryData.COLUMN_COUNTRY_CAPITAL,
                InsertCountryData.COLUMN_COUNTRY_CITY_01,
                InsertCountryData.COLUMN_COUNTRY_CITY_02,
                InsertCountryData.COLUMN_COUNTRY_CITY_03

        };

        //Cursor
        Cursor cursor = getContentResolver().query(
                InsertCountryData.CONTENT_URI,
                projection,
                null,
                null,
                null
        );
        */

        //make connection with the SQLite database
         db= mDbHelper.getWritableDatabase();
/*
        ContentValues values = new ContentValues();
        values.put(InsertCountryData.COLUMN_COUNTRY_NAME, "Name 1");
        values.put(InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Language");
        values.put(InsertCountryData.COLUMN_COUNTRY_POPULATION, 55555);
        values.put(InsertCountryData.COLUMN_COUNTRY_CURRENCY, "type name");
        values.put(InsertCountryData.COLUMN_COUNTRY_CAPITAL, "capital");
        values.put(InsertCountryData.COLUMN_COUNTRY_CITY_01, "more cities");
        values.put(InsertCountryData.COLUMN_COUNTRY_CITY_02, "more cities");
        values.put(InsertCountryData.COLUMN_COUNTRY_CITY_03, "more cities");


        Long rowId = db.insert(InsertCountryData.TABLE_NAME, null, values);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);

         //Uri newUri =
*/
        ContentValues values01 = new ContentValues();
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "France");
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "French");
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 67);
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro");
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Paris");
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Marseille");
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_02, "Lyon");
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_03, "Strasobourg");
        values01.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_04, "Bordeaux");

        Long rowId01 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values01);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);

/*

        ContentValues values02 = new ContentValues();
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Spain");
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Spanish");
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 47);
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro");
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Madrid");
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Barcelona");
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_02, "Seville");
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_03, "Granada");
        values02.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_04, "Valencia");

        Long rowId02 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values02);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);


        ContentValues values03 = new ContentValues();
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "China");
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Chinese");
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 1430);
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Yuan");
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Beijing");
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Hangzhou");
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_02, "Gullin");
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_03, "Chengdu");
        values03.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_04, "Guangzhou");

        Long rowId03 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values03);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);


        ContentValues values04 = new ContentValues();
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Italy");
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Italian");
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 60);
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro");
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Rome");
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Venice");
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_02, "Florence");
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_03, "Milan");
        values04.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_04, "Naples");

        Long rowId04 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values04);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);

        ContentValues values05 = new ContentValues();
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Australia");
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "English ");
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 23);
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Australian Dollar(AUD)");
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Canberra");
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Sydney");
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_02, "Melbourne");
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_03, "Craigieburn");
        values05.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_04, "Perth");

        Long rowId05 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values05);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);

        ContentValues values06 = new ContentValues();
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Greece");
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Greek");
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 11);
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Euro(EUR)");
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Athens");
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Loannina");
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_02, "Corfu town");
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_03, "Rethymno");
        values06.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_04, "Naples");

        Long rowId06 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values06);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);

        ContentValues values07 = new ContentValues();
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "New Zealand");
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "English ");
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 4);
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "New Zealand Dollar(NZD)");
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Wellington ");
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Sydney");
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Melbourne");
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Craigieburn");
        values07.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Perth ");

        Long rowId07 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values07);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);


        ContentValues values08 = new ContentValues();
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Thailand");
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Central Thai");
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 69);
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Thai baht");
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Bangkok");
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Nonthaburi");
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Pak Kret");
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Hat Yai");
        values08.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Nakhon Ratchasima");

        Long rowId08 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values08);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);

        ContentValues values09 = new ContentValues();
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_NAME, "Japan");
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_LANGUAGE, "Hachijo Japanese");
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_POPULATION, 126);
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CURRENCY, "Japanese yen");
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CAPITAL, "Tokyo");
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Nagoya");
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Okazaki");
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Kasugai");
        values09.put(CountryContract.InsertCountryData.COLUMN_COUNTRY_CITY_01, "Tsushima");

        Long rowId09 = db.insert(CountryContract.InsertCountryData.TABLE_NAME, null, values09);
        Log.i("CountryDbHelper", "NEW ROW ID :"+ CountryContract.InsertCountryData.COLUMN_COUNTRY_ID);


        //we used null because it is a new row

        //Toast.makeText(this, "Error inserting :", Toast.LENGTH_LONG).show();

*/
        //connection close
        db.close();
    }
}
