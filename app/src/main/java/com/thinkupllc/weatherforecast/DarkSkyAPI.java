package com.thinkupllc.weatherforecast;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface DarkSkyAPI {

    String BASE_URL = "https://api.forecast.io/forecast/";

    @GET("cbaa9628d88936e14d77ecdba8aefa2e/39.942990,-75.26986") Call<Weather> getWeather();

    class Factory {

        private static DarkSkyAPI service;
        public static DarkSkyAPI getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                        .baseUrl(BASE_URL)
                        .build();

                service = retrofit.create(DarkSkyAPI.class);
                return service;
            } else {
                return service;
            }
        }
    }

}
