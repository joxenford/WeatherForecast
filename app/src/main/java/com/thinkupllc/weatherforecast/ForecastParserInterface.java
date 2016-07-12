package com.thinkupllc.weatherforecast;

import org.jdeferred.Promise;

public interface ForecastParserInterface {

    Promise<Weather, String, String> getForecast(String forecastURL);

    Promise<Weather, String, String> promise();

}

