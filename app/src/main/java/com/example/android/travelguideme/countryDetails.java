package com.example.android.travelguideme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.travelguideme.data.CountryContract.InsertCountryData;
import com.example.android.travelguideme.data.CountryDbHelper;


public class countryDetails extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    //identify a certain loader
    private static final int COUNTRY_LOADER = 0;

    private Uri mCurrentCountryUri;

    CountryCursorAdapter mCursorAdapter;

    private CountryDbHelper mDbHelper;

    private TextView countryName;
    private TextView countryPopulation;
    private TextView countryCapital;
    private TextView countryCurrency;
    private TextView country_CITY_01;
    private TextView country_CITY_02;
    private TextView country_CITY_03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        //have to use getIntent and getData the associated uri
        Intent intent = getIntent();

        if(mCurrentCountryUri == null){
            setTitle(getString(R.string.data_not_available));
        }else{
            setTitle(getString(R.string.data_available));
            // Initialize a loader to read the pet data from the database
            // and display the current values in the editor
            LoaderManager.getInstance(this).initLoader(COUNTRY_LOADER, null, this);
        }

        // Find all relevant views that we will need to read user input from
        countryName = findViewById(R.id.country_name);
        countryPopulation = findViewById(R.id.population_view);
        countryCapital = findViewById(R.id.capital_view);
        countryCurrency = findViewById(R.id.currency_view);
        country_CITY_01 = findViewById(R.id.city_1_view);
        country_CITY_02 = findViewById(R.id.city_2_view);
        country_CITY_03 = findViewById(R.id.city_3_view);

        mDbHelper = new CountryDbHelper(this);


    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        //projection defined
        String[] projection = {
                InsertCountryData._ID,
                InsertCountryData.COLUMN_COUNTRY_NAME,
                InsertCountryData.COLUMN_COUNTRY_CAPITAL,
                InsertCountryData.COLUMN_COUNTRY_LANGUAGE,
                InsertCountryData.COLUMN_COUNTRY_CURRENCY,
                InsertCountryData.COLUMN_COUNTRY_POPULATION,
                InsertCountryData.COLUMN_COUNTRY_CITY_01,
                InsertCountryData.COLUMN_COUNTRY_CITY_02,
                InsertCountryData.COLUMN_COUNTRY_CITY_03
        };
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
