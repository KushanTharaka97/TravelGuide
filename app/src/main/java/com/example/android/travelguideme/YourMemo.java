package com.example.android.travelguideme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.travelguideme.data.CountryContract;
import com.example.android.travelguideme.data.CountryData;
import com.example.android.travelguideme.data.CountryDbHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.android.travelguideme.data.CountryContract.InsertCountryData;

public class YourMemo extends AppCompatActivity {

    private CountryDbHelper mDbHelper;
    CountryData insertObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_memo);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YourMemo.this, MainActivity.class);
                startActivity(intent);
                insertData();
                finish();
            }
        });
    mDbHelper = new CountryDbHelper(this);
        displayDatabaseInfo();

    }


    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM pets"
        // to get a Cursor that contains all rows from the pets table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + InsertCountryData.TABLE_NAME +";", null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).
            TextView displayView = (TextView) findViewById(R.id.viewTest);
            displayView.setText("Number of rows : " + cursor.getCount());
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

    private void insertData(){

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

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

    }
}
