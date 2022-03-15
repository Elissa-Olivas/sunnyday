package com.detroitlabs.sunnyday.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast { //weatherService Class is creating a method that will get data and ignore anything other than name.
    String name;
    Temperature temperature;
    Wind wind;
    Clouds cloudAllPercent;
    Sys sys;
    Coord coord;
    List<Weather> weather;
    double visibility;
    long dt;


    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("sys")
    public Sys getSys() {
        return sys;
    }
    @JsonProperty("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonProperty("clouds")
    public Clouds getCloudAllPercent() {
        return cloudAllPercent;
    }
    @JsonProperty("clouds")
    public void setCloudAllPercent(Clouds cloudAllPercent) {
        this.cloudAllPercent = cloudAllPercent;
    }


    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonProperty("main") //enter property of the info we want to get
    public Temperature getTemperature() {
        return temperature;
    }

    @JsonProperty("main") //the property is actually named Main in JSON
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
