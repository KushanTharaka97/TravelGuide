package com.example.android.travelguideme.data;

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
    }

}
