package com.thinkupllc.weatherforecast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.jdeferred.DoneCallback;
import org.jdeferred.FailCallback;
import org.jdeferred.Promise;

import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    Promise<Weather, String, String> weather;
    CoreFactory coreFactory = new CoreFactoryProd();

    final ForecastParserInterface forecastParserInterface = coreFactory.forecastParser();
    final ForecastEndpointInterface forecastEndpointInterface = coreFactory.endpoint();
    final String forecastURL = forecastEndpointInterface.forecastEndpoint();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weather = forecastParserInterface.getForecast(forecastURL);

        weather.done(new DoneCallback<Weather>() {
            public void onDone(Weather weather) {
                out.print(weather);
            }
        });
        weather.fail(new FailCallback() {
            public void onFail(Object rejection) {
                out.print(rejection);
            }
        });


        System.out.print(weather);
    }
}
