package com.thinkupllc.weatherforecast;

public class Weather {

    String latitude;
    String longitude;
    Currently currently;

    @Override
    public String toString() {
        return this.latitude + " " + this.longitude + " " + this.currently;

    }
}
