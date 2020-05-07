package com.agambajwa.covidtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int position;

    TextView tvCountryCases, tvCountryRecovered, tvCountryCritical, tvCountryActive, tvCountryCasesToday, tvCountryDeaths, tvCountryDeathsToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

        getSupportActionBar().setTitle(AffectedCountries.countryModelList.get(position).getCountryName() + "'s statistics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvCountryCases = findViewById(R.id.tvCountryCases);
        tvCountryRecovered = findViewById(R.id.tvCountryRecovered);
        tvCountryCritical = findViewById(R.id.tvCountryCritical);
        tvCountryActive = findViewById(R.id.tvCountryActive);
        tvCountryCasesToday = findViewById(R.id.tvCountryCasesToday);
        tvCountryDeaths = findViewById(R.id.tvCountryDeaths);
        tvCountryDeathsToday = findViewById(R.id.tvCountryDeathsToday);

        tvCountryCases.setText(AffectedCountries.countryModelList.get(position).getCases());
        tvCountryRecovered.setText(AffectedCountries.countryModelList.get(position).getRecovered());
        tvCountryCritical.setText(AffectedCountries.countryModelList.get(position).getCritical());
        tvCountryActive.setText(AffectedCountries.countryModelList.get(position).getActive());
        tvCountryCasesToday.setText(AffectedCountries.countryModelList.get(position).getCasesToday());
        tvCountryDeaths.setText(AffectedCountries.countryModelList.get(position).getCases());
        tvCountryDeathsToday.setText(AffectedCountries.countryModelList.get(position).getDeathsToday());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
