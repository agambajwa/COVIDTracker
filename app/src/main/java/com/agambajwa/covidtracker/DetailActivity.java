package com.agambajwa.covidtracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.BarModel;

public class DetailActivity extends AppCompatActivity {

    private int position;
    BarChart barChart;

    TextView tvCountryName, tvCountryCases, tvCountryRecovered, tvCountryCritical, tvCountryActive, tvCountryCasesToday, tvCountryDeaths, tvCountryDeathsToday, tvCountryTests;
    ImageView ivCountryFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        getSupportActionBar().setTitle("Country specific statistics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

        ivCountryFlag = findViewById(R.id.ivCountryFlag);
        tvCountryName = findViewById(R.id.tvCountryName);
        tvCountryCases = findViewById(R.id.tvCountryCases);
        tvCountryRecovered = findViewById(R.id.tvCountryRecovered);
        tvCountryCritical = findViewById(R.id.tvCountryCritical);
        tvCountryActive = findViewById(R.id.tvCountryActive);
        tvCountryCasesToday = findViewById(R.id.tvCountryCasesToday);
        tvCountryDeaths = findViewById(R.id.tvCountryDeaths);
        tvCountryDeathsToday = findViewById(R.id.tvCountryDeathsToday);
        tvCountryTests = findViewById(R.id.tvCountryTests);
        barChart = findViewById(R.id.barChart);

        Glide.with(DetailActivity.this).load(AffectedCountries.countryModelList.get(position).getCountryFlag()).into(ivCountryFlag);
        tvCountryName.setText(AffectedCountries.countryModelList.get(position).getCountryName());
        tvCountryCases.setText(AffectedCountries.countryModelList.get(position).getCases());
        tvCountryRecovered.setText(AffectedCountries.countryModelList.get(position).getRecovered());
        tvCountryCritical.setText(AffectedCountries.countryModelList.get(position).getCritical());
        tvCountryActive.setText(AffectedCountries.countryModelList.get(position).getActive());
        tvCountryCasesToday.setText(AffectedCountries.countryModelList.get(position).getCasesToday());
        tvCountryDeaths.setText(AffectedCountries.countryModelList.get(position).getDeaths());
        tvCountryDeathsToday.setText(AffectedCountries.countryModelList.get(position).getDeathsToday());
        tvCountryTests.setText(AffectedCountries.countryModelList.get(position).getTests());

        barChart.addBar(new BarModel(Float.parseFloat(tvCountryCases.getText().toString()), Color.parseColor("#FFA726")));
        barChart.addBar(new BarModel(Float.parseFloat(tvCountryDeaths.getText().toString()), Color.parseColor("#EF5350")));
        barChart.addBar(new BarModel(Float.parseFloat(tvCountryRecovered.getText().toString()),  Color.parseColor("#66BB6A")));
        barChart.addBar(new BarModel(Float.parseFloat(tvCountryActive.getText().toString()), Color.parseColor("#29B6F6")));
        barChart.addBar(new BarModel(Float.parseFloat(tvCountryCritical.getText().toString()), Color.parseColor("#FFEB3B")));
        barChart.addBar(new BarModel(Float.parseFloat(tvCountryTests.getText().toString()), Color.parseColor("#009688")));
        barChart.startAnimation();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
