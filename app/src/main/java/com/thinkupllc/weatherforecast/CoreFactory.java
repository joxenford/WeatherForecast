package com.thinkupllc.weatherforecast;

abstract class CoreFactory {

    private ForecastEndpointInterface endpoint;

    protected abstract ForecastEndpointInterface endpoint();
}
