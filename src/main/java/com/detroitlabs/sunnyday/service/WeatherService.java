package com.detroitlabs.sunnyday.service;

import com.detroitlabs.sunnyday.model.Forecast;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component //this is coming from SPRING not Jackson -
// tells spring how to assemble the web application, how to connect to other services

public class WeatherService {

    //method that returns forecast model
    public Forecast fetchWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        //getForObject - allow to pass in a web address with the arguments and model class to map the results.
        return restTemplate.getForObject(
                "http://api.openweathermap.org" +
                        "/data/2.5/weather?q=Denver" +
                        "&APPID=9bf4592554a97f9491feca4ee010dd41", Forecast.class); //takes a parameter of a CLASS not an Object.

    }
}
