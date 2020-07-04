package com.example.android.travelguideme.data;

import android.provider.BaseColumns;

public class CountryContract implements BaseColumns {
    //The main table name of the  App
    public static final String TABLE_NAME = "countries";

    //auto incrementing id
    public static final String COLUMN_COUNTRY_ID = BaseColumns._ID;

    public static final String COLUMN_COUNTRY_NAME = "country";

    public static final String COLUMN_COUNTRY_CURRENCY = "currency";

    public static final String COLUMN_COUNTRY_LANGUAGE = "language";

    public static final String COLUMN_COUNTRY_CAPITAL = "capital";

    public static final String COLUMN_COUNTRY_CITIES = "cities";

    public static final String COLUMN_COUNTRY_POPULATION = "population";
}
