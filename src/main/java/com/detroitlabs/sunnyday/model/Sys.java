package com.detroitlabs.sunnyday.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {
    long sunrise;
    long sunset;

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {

        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }


}
