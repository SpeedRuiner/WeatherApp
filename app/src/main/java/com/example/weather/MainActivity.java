package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFindCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFindCity = findViewById(R.id.EditTextfindCity);
    }

    public void onClickWeatherForecast(View view) {
        String nameCity = editTextFindCity.getText().toString().trim();
        if (!nameCity.isEmpty()){
            Intent weatherIntent = new Intent(this, WeatherForecastActivity.class);
            weatherIntent.putExtra("name", nameCity);
            startActivity(weatherIntent);
        } else {
            Toast.makeText(this, R.string.enter_city, Toast.LENGTH_SHORT).show();
        }

    }
}
