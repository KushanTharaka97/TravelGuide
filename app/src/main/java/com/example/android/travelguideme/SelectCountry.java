package com.example.android.travelguideme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.travelguideme.data.CountryContract;
import com.example.android.travelguideme.data.CountryContract.InsertCountryData;
import com.example.android.travelguideme.data.CountryDbHelper;

public class SelectCountry extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private CountryDbHelper mDbHelper;

    //identify a certain loader
    private static final int COUNTRY_LOADER = 0;

    CountryCursorAdapter mCursorAdapter;

    /** Tag for the log messages */
    public static final String LOG_TAG = SelectCountry.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);

        mDbHelper = new CountryDbHelper(this);
       // displayDatabaseInfo();

        //display in List
        ListView petDisplayList = findViewById(R.id.country_list);


        //kick off the loader
        //getLoaderManager().initLoader(PET_LOADER,null,this);
        LoaderManager.getInstance(this).initLoader(COUNTRY_LOADER, null, this);

    }

    //method implementing for display all the countries in this window

    /*
    private void displayDatabaseInfo(){
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.

        //display in this space
        //TextView displayView = findViewById(R.id.text_view_country);

        //using Uri method to call the database
        String[] projection = {
                InsertCountryData.COLUMN_COUNTRY_NAME,
                InsertCountryData.COLUMN_COUNTRY_CURRENCY,
                InsertCountryData.COLUMN_COUNTRY_POPULATION,
                InsertCountryData.COLUMN_COUNTRY_LANGUAGE,
                InsertCountryData.COLUMN_COUNTRY_CAPITAL,
                InsertCountryData.COLUMN_COUNTRY_CITY_01,
                InsertCountryData.COLUMN_COUNTRY_CITY_02
        };

        //Creating a cursor for show content one by one
        Cursor cursor = getContentResolver().query(
                InsertCountryData.CONTENT_URI,
                projection,
                null,
                null,
                null
        );

        try{
            //count of the table rows
            displayView.setText("Number of rows in pets database table: " + cursor.getCount());

            //testing
            displayView.append("\n"+
                    InsertCountryData.COLUMN_COUNTRY_NAME+"   "
                    +InsertCountryData.COLUMN_COUNTRY_LANGUAGE+"   "
                    );
            //figureout the index of each column
            int nameOfTheCountry = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_NAME);
            int theLanguageUsing = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_LANGUAGE);
            while (cursor.moveToNext()){
                String countryName = cursor.getString(nameOfTheCountry);
                String countryLanguage = cursor.getString(theLanguageUsing);

                displayView.append("\n"+
                countryName+"   "
                +countryLanguage);
            }


        }catch(Exception e){
            Log.e(LOG_TAG,"Error Occured due to "+ e);
        }finally {
            cursor.close();
        }


    }

     */

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        //projection defined
        String[] projection = {
                InsertCountryData._ID,
                InsertCountryData.COLUMN_COUNTRY_NAME,
                InsertCountryData.COLUMN_COUNTRY_CAPITAL
        };
        return new CursorLoader(this, InsertCountryData.CONTENT_URI,projection, null, null, null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

            mCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

        mCursorAdapter.swapCursor(null);
    }
}
