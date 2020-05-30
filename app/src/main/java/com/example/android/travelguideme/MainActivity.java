package com.example.android.travelguideme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView selectCountry = (TextView) findViewById(R.id.selectCountry);

        TextView yourFovourite = (TextView) findViewById(R.id.yourFavourite);

        TextView yourMemo = (TextView) findViewById(R.id.yourMemo);

        TextView aboutUs = (TextView) findViewById(R.id.aboutUs);
    }
}
