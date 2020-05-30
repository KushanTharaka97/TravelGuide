package com.example.android.travelguideme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView selectCountry = (TextView) findViewById(R.id.selectCountry);
        //making on click lisner when layout click specific id this method will be called
        selectCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //make a simple toast message to show
                Toast.makeText(MainActivity.this,"Slect Country" ,Toast.LENGTH_SHORT).show();

                //creating intent to transfering
                Intent intent = new Intent(MainActivity.this , SelectCountry.class);
                startActivity(intent);
            }
        });

        TextView yourFovourite = (TextView) findViewById(R.id.yourFavourite);

        TextView yourMemo = (TextView) findViewById(R.id.yourMemo);

        TextView aboutUs = (TextView) findViewById(R.id.aboutUs);
    }
}
