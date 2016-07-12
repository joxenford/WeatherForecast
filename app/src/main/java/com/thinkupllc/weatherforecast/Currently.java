package com.thinkupllc.weatherforecast;

public class Currently {

    String summary;
    String nearestStormDistance;

    @Override
    public String toString() {
        return this.summary + " " + this.nearestStormDistance;

    }
}
