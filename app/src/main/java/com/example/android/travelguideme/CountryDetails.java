package com.example.android.travelguideme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.travelguideme.data.CountryContract.InsertCountryData;
import com.example.android.travelguideme.data.CountryDbHelper;


public class CountryDetails extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String LOG_TAG = CountryDetails.class.getSimpleName();

    //identify a certain loader
    private static final int COUNTRY_LOADER = 0;

    private Uri mCurrentCountryUri;

    CountryCursorAdapter mCursorAdapter;

    private CountryDbHelper mDbHelper;

    private TextView countryName;
    private TextView countryPopulation;
    private TextView countryCapital;
    private TextView countryLanguage;
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
        mCurrentCountryUri = intent.getData();

        if(mCurrentCountryUri == null){
            setTitle(getString(R.string.data_not_available));
            Log.e(LOG_TAG,"Doesn't pass uri");
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
        countryLanguage = findViewById(R.id.language_view);
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

        return new CursorLoader(
                this,
                mCurrentCountryUri,
                projection,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        if(cursor == null){
            return;
        }

        if(cursor.moveToNext()){
            int nameColumnIndex = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_NAME);
            int capitalColumnIndex = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_CAPITAL);
            int languageColumnIndex = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_LANGUAGE);
            int currencyColumnIndex = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_CURRENCY);
            int populationColumnIndex = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_POPULATION);
            int city01_ColumnIndex = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_CITY_01);
            int city02_ColumnIndex = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_CITY_02);
            int city03_ColumnIndex = cursor.getColumnIndex(InsertCountryData.COLUMN_COUNTRY_CITY_03);

            // Extract out the value from the Cursor for the given column index
            String CountryName = cursor.getString(nameColumnIndex);
            String CountryCapital = cursor.getString(capitalColumnIndex);
            String CountryLanguage = cursor.getString(languageColumnIndex);
            String CountryCurrency = cursor.getString(currencyColumnIndex);
            int CountryPopulation = cursor.getInt(populationColumnIndex);
            String CountryCity01 = cursor.getString(city01_ColumnIndex);
            String CountryCity02 = cursor.getString(city02_ColumnIndex);
            String CountryCity03 = cursor.getString(city03_ColumnIndex);

            countryName.setText(CountryName);
            countryPopulation.setText(Integer.toString(CountryPopulation));
            countryCapital.setText(CountryCapital);
            countryLanguage.setText(CountryLanguage);
            countryCurrency.setText(CountryCurrency);
            country_CITY_01.setText(CountryCity01);
            country_CITY_02.setText(CountryCity02);
            country_CITY_03.setText(CountryCity03);


        }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

        countryName.setText("");
        countryPopulation.setText("");
        countryLanguage.setText("");
        countryCurrency.setText("");
        countryCapital.setText("");
        country_CITY_01.setText("");
        country_CITY_02.setText("");
        country_CITY_03.setText("");
    }
}
