package com.thinkupllc.weatherforecast;

abstract class CoreFactory {

    private URLFetcher URLfetcher;
    private ForecastEndpointInterface endpoint;
    private ForecastParserInterface parser;

    protected abstract URLFetcher urlFetcher();
    protected abstract ForecastEndpointInterface endpoint();
    protected abstract ForecastParserInterface forecastParser();
}
