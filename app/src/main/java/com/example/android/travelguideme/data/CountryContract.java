package com.example.android.travelguideme.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class CountryContract  {
    public static abstract class InsertCountryData implements BaseColumns{

        //The main table name of the  App
        public static final String TABLE_NAME = "countries";

        //auto incrementing id
        public static final String COLUMN_COUNTRY_ID = BaseColumns._ID;

        public static final String COLUMN_COUNTRY_NAME = "country";

        public static final String COLUMN_COUNTRY_CURRENCY = "currency";

        public static final String COLUMN_COUNTRY_LANGUAGE = "language";

        public static final String COLUMN_COUNTRY_CAPITAL = "capital";

        public static final String COLUMN_COUNTRY_CITY_01 = "city01";
        public static final String COLUMN_COUNTRY_CITY_02 = "city02";
        public static final String COLUMN_COUNTRY_CITY_03 = "city03";
        public static final String COLUMN_COUNTRY_CITY_04 = "city04";

        public static final String COLUMN_COUNTRY_POPULATION = "population";

        public static final String COLUMN_COUNTRY_FAVOURITE = "favourite";

        /*
    Lastly, inside each of the Entry classes in the contract,
    we create a full URI for the class as a constant called CONTENT_URI.
     The Uri.withAppendedPath() method appends the BASE_CONTENT_URI
    (which contains the scheme and the content authority) to the path segment.
     */

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_COUNTRIES);
    }

    //Content Authority
    public static final String CONTENT_AUTHORITY = "com.example.android.travelguideme";

    //To make this a usable URI, we use the parse method which takes in a URI string and returns a Uri.
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_COUNTRIES = InsertCountryData.TABLE_NAME;

}
