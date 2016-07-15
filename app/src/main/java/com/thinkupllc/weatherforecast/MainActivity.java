package com.thinkupllc.weatherforecast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView mForecastTextView;
    private ProgressBar mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mForecastTextView = (TextView) findViewById(R.id.forecastTextView);
        mSpinner = (ProgressBar) findViewById(R.id.forecastProgress);

        getForcast();
    }

    private void getForcast() {
        DarkSkyAPI.Factory.getInstance().getWeather().enqueue(new Callback<Weather>() {
           @Override
           public void onResponse(Call<Weather> call, Response<Weather> response) {
               Log.d(TAG, response.body().toString());
               mSpinner.setVisibility(View.GONE);
               mForecastTextView.setText(response.body().toString());
           }

           @Override
           public void onFailure(Call<Weather> call, Throwable t) {
               Log.d(TAG, t.toString());
           }
       });
    }
}
