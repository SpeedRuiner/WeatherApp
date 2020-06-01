package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFindCity;
    private CheckBox checkBoxHumidity;
    private CheckBox checkBoxWind;
    private CheckBox checkBoxPressure;
    private StringBuilder builderVales;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFindCity = findViewById(R.id.EditTextFindCity);
        checkBoxHumidity = findViewById(R.id.checkboxHumidity);
        checkBoxPressure = findViewById(R.id.checkboxPressure);
        checkBoxWind = findViewById(R.id.checkboxWind);
        builderVales = new StringBuilder();
    }

    public void onClickWeatherForecast(View view) {
        String nameCity = editTextFindCity.getText().toString().trim();

        builderVales.setLength(0);
        if (checkBoxWind.isChecked()) {
            builderVales.append(getString(R.string.wind)).append(" ");
        }
        if (checkBoxPressure.isChecked()) {
            builderVales.append(getString(R.string.pressure)).append(" ");
        }
        if (checkBoxHumidity.isChecked()) {
            builderVales.append(getString(R.string.humidity)).append(" ");
        }
        String values;
        if (builderVales.length() > 0){
            values = getString(R.string.vales_of_weather) + builderVales.toString();
        } else {
            values = "";
        }
        String fullVales = nameCity + values;
        if (!nameCity.isEmpty()) {
            Intent weatherIntent = new Intent(this, WeatherForecastActivity.class);
            weatherIntent.putExtra("name", fullVales);
            startActivity(weatherIntent);
        } else {
            Toast.makeText(this, R.string.enter_city, Toast.LENGTH_SHORT).show();
        }

    }
}
