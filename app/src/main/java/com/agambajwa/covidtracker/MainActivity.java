package com.agambajwa.covidtracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tvCases, tvRecovered, tvCritical, tvActive, tvCasesToday, tvDeaths, tvDeathsToday, tvAffectedCountries;
    SimpleArcLoader simpleArcLoader;
    ScrollView scrollView;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("COVID-19 Tracker");

        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvCasesToday = findViewById(R.id.tvCasesToday);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvDeathsToday = findViewById(R.id.tvDeathsToday);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);

        simpleArcLoader = findViewById(R.id.loader);
        scrollView = findViewById(R.id.svGlobalStats);
        barChart = findViewById(R.id.barChart);

        fetchData();

    }

    private void fetchData() {

        String url = "https://corona.lmao.ninja/v2/all/";
        simpleArcLoader.start();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvCases.setText(jsonObject.getString("cases"));
                    tvRecovered.setText(jsonObject.getString("recovered"));
                    tvCritical.setText(jsonObject.getString("critical"));
                    tvActive.setText(jsonObject.getString("active"));
                    tvCasesToday.setText(jsonObject.getString("todayCases"));
                    tvDeaths.setText(jsonObject.getString("deaths"));
                    tvDeathsToday.setText(jsonObject.getString("todayDeaths"));
                    tvAffectedCountries.setText(jsonObject.getString("affectedCountries"));

                    barChart.addBar(new BarModel(Float.parseFloat(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                    barChart.addBar(new BarModel(Float.parseFloat(tvDeaths.getText().toString()), Color.parseColor("#EF5350")));
                    barChart.addBar(new BarModel(Float.parseFloat(tvRecovered.getText().toString()),  Color.parseColor("#66BB6A")));
                    barChart.addBar(new BarModel(Float.parseFloat(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
                    barChart.addBar(new BarModel(Float.parseFloat(tvCritical.getText().toString()), Color.parseColor("#FFEB3B")));
                    barChart.startAnimation();

                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);

                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "Error Occurred! "+ error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void countryDetails(View view) {
        startActivity(new Intent(getApplicationContext(), AffectedCountries.class));
    }

    public void aboutActivity(View view) {
        startActivity(new Intent(getApplicationContext(), About.class));
    }
}
