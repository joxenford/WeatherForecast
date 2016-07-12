package com.thinkupllc.weatherforecast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jdeferred.Deferred;
import org.jdeferred.DoneCallback;
import org.jdeferred.Promise;
import org.jdeferred.impl.DeferredObject;

import static java.lang.System.out;

public class DarkSkyForecastParser implements ForecastParserInterface {

    final Deferred<Weather, String, String> deferred = new DeferredObject<Weather, String, String>();

    public Promise<Weather, String, String> getForecast(String forecastURL) {

        //String gsonString;
        Weather weather = new Weather();
        URLFetcher fetcher = new URLFetcher();

        try {
            Promise<String, String, String> gsonString = fetcher.fetchURL(forecastURL);
            gsonString.done(new DoneCallback <String>() {
                public void onDone(String gsonString) {
                    out.print(gsonString);
                }
            });

            try {

                Gson gson = new GsonBuilder().create();
            //    weather = gson.fromJson(gsonString, Weather.class);
                deferred.resolve(weather);

            } catch (Exception e) {
                // System.out.print(e.toString());
                deferred.reject("failed to parser");
            }
        } catch (Exception e) {
            //System.out.print(e.toString());
            deferred.reject("failed to connect");
        }
        return promise();
    }
    public Promise<Weather, String, String> promise() {
        return deferred;
    }
}
