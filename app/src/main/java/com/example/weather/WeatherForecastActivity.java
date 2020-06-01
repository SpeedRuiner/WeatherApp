package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
        TextView textViewValues = findViewById(R.id.textViewValues);
        Intent weatherIntent = getIntent();
        if (weatherIntent.hasExtra("name")){
            String name = weatherIntent.getStringExtra("name");
            textViewValues.setText(name);
        } else {
            Intent backToMain = new Intent(this, MainActivity.class);
            startActivity(backToMain);
        }

    }
}
