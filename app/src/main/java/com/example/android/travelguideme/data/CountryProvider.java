package com.example.android.travelguideme.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.example.android.travelguideme.data.CountryContract.InsertCountryData;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CountryProvider extends ContentProvider {
    /** Tag for the log messages */
    public static final String LOG_TAG = CountryProvider.class.getSimpleName();

    /** URI matcher code for the content URI for the country table */
    private static final int COUNTRIES = 100;

    /** URI matcher code for the content URI for a single country in country table */
    private static final int COUNTRY_ID = 101;

    /**
     * UriMatcher object to match a content URI to a corresponding code.
     * The input passed into the constructor represents the code to return for the root URI.
     * It's common to use NO_MATCH as the input for this case.
     */
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // Static initializer. This is run the first time anything is called from this class.
    static {
        // The calls to addURI() go here, for all of the content URI patterns that the provider
        // should recognize. All paths added to the UriMatcher have a corresponding code to return
        // when a match is found.

        sUriMatcher.addURI(CountryContract.CONTENT_AUTHORITY, CountryContract.PATH_COUNTRIES, COUNTRIES);
        sUriMatcher.addURI(CountryContract.CONTENT_AUTHORITY,CountryContract.PATH_COUNTRIES+ "/#" ,COUNTRY_ID);
    }
    private CountryDbHelper mCountryHelperObject;

    @Override
    public boolean onCreate() {

        // Make sure the variable is a global variable, so it can be referenced from other
        // ContentProvider methods.
        mCountryHelperObject = new CountryDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        //created object to read the db by uri
        SQLiteDatabase database = mCountryHelperObject.getReadableDatabase();

        Cursor cursor;
        //match the transerd uri from below method
        int match = sUriMatcher.match(uri);
        switch (match){
            //if uri match with COUNTRIES 100
            case COUNTRIES:
                cursor = database.query(InsertCountryData.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;

                //if uri match with the certain id
            case COUNTRY_ID:
                selection = InsertCountryData.COLUMN_COUNTRY_ID+"=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(InsertCountryData.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
                break;

            default:
                throw new IllegalArgumentException("Cannot make the request of :"+ uri);
        }

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }


    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        final int match = sUriMatcher.match(uri);
        switch(match){
            case COUNTRIES:
                return insertCountries(uri, values);
            default:
                throw new IllegalArgumentException("Insertion Not Suppor for "+ uri);
         }
    }

    private Uri insertCountries(Uri uri, ContentValues values){
        SQLiteDatabase databaseForInsertion = mCountryHelperObject.getWritableDatabase();

        // Defines an object to contain the new values to insert
        long id = databaseForInsertion.insert(InsertCountryData.TABLE_NAME,null,values);
        if(id == -1){
            Log.e(LOG_TAG,"Failed to insert "+ uri);
            return null;
        }
        return ContentUris.withAppendedId(uri, id);

    }


    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
