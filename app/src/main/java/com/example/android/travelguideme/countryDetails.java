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


public class countryDetails extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    //identify a certain loader
    private static final int COUNTRY_LOADER = 0;

    private Uri mCurrentCountryUri;

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
        }

    }
}
