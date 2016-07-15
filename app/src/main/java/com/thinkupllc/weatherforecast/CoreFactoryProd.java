package com.thinkupllc.weatherforecast;

public class CoreFactoryProd extends CoreFactory {

    private ForecastEndpointInterface endpoint;

    CoreFactoryProd() {

    }
    @Override
    protected ForecastEndpointInterface endpoint() {
        return this.endpoint;
    }
}
