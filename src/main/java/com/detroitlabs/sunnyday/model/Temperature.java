package com.detroitlabs.sunnyday.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    double temp;
    int humidity;
    double tempInFahrenheit;


    public double getTempInFahrenheit() {
        return tempInFahrenheit;
    }

    public void setTempInFahrenheit(double tempInFahrenheit) {
        this.tempInFahrenheit = tempInFahrenheit;
    }


    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
