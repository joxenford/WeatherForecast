package com.thinkupllc.weatherforecast;

public class DarkSkyEndpoint implements ForecastEndpointInterface {

    public String forecastEndpoint() {
       return "https://api.forecast.io/forecast/";
    }
}


