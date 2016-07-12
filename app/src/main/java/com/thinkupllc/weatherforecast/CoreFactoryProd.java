package com.thinkupllc.weatherforecast;

public class CoreFactoryProd extends CoreFactory {

    private URLFetcher urlFetcher;
    private ForecastEndpointInterface endpoint;
    private ForecastParserInterface parser;

    CoreFactoryProd() {
        this.urlFetcher = new URLFetcher();
        this.endpoint = new DarkSkyEndpoint();
        this.parser = new DarkSkyForecastParser();
    }

    @Override
    protected URLFetcher urlFetcher() {
        return this.urlFetcher;
    }

    @Override
    protected ForecastEndpointInterface endpoint() {
        return this.endpoint;
    }
    @Override
    protected ForecastParserInterface forecastParser() {
        return this.parser;
    }
}
