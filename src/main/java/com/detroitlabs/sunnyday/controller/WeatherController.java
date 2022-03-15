package com.detroitlabs.sunnyday.controller;

import com.detroitlabs.sunnyday.model.*;
import com.detroitlabs.sunnyday.model.Weather;
import com.detroitlabs.sunnyday.service.WeatherService;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.api.scripting.ScriptUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
public class WeatherController {
    WeatherService weatherService = new WeatherService();

    @ResponseBody
    @RequestMapping("/")

    public String displayWeather() throws ParseException {
        Forecast forecast = weatherService.fetchWeatherData(); //Object Forecast value is equal to fetcheatherdata that is in our weatherservice.
        Temperature temperature = forecast.getTemperature();
        Wind wind = forecast.getWind();
        Clouds cloudPercent = forecast.getCloudAllPercent();
        Sys sys = forecast.getSys();
        Weather weather = forecast.getWeather().get(0);
        Coord coord = forecast.getCoord();
        double lat = coord.getLat();
        double lon = coord.getLon();
        long sunrise = (sys.getSunrise());
        long sunset = (sys.getSunset());
        long dt = (forecast.getDt());
        int humidity = temperature.getHumidity();
        double tempInF = (temperature.getTemp()- 273.15) * 1.8 + 32;
        String latString = String.valueOf(lat);
        String lonString = String.valueOf(lon);
        String cloudPercentString = String.valueOf(cloudPercent.getAll());
        String windSpeedString = String.valueOf(wind.getSpeed());
        String tempFString = String.valueOf(tempInF);
        String humidityString = String.valueOf(humidity);
        String tempString = String.valueOf(temperature.getTemp());

        //time conversion
        Date date = new Date(sunrise);
        Date sunsetDate = new Date(sunset);
        DateFormat format = new SimpleDateFormat("HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        format.setTimeZone(TimeZone.getTimeZone("MST"));
        //converting sunrise
        String formatted = format.format(date);
        formatted = format.format(date);
        //converting sunset
        String formattedSunset = format.format(sunsetDate);
        formattedSunset = format.format(sunsetDate);

        //converting date
        Instant instant = Instant.ofEpochSecond(dt);
        Date todaysDate = Date.from( instant );




        return  "<h1>Today is " + todaysDate + "</h1>" + "<hr>" + "<br>" + "<h2>" + forecast.getName() + ":" + "</h2>" + "<br>" + "Latitude: " + latString + ", Longitude: " + lonString + "<br>" +
                "The current temperature is " + tempString + "K/" + tempFString + "F. <br> Humidity of " + humidityString + "%. Cloud percentage " + cloudPercentString + "% and Wind Speed of " + windSpeedString + "mph" + "<br>"+
                " Sunrise starts at " + formatted + "UTC and Sunset is at " + formattedSunset + "UTC" + "<br>" + "Additional weather details: " + weather.getId() + " " +
                weather.getMain() + " " + weather.getDescription() + " " + weather.getIcon() + " and has a Visibility of " + forecast.getVisibility()+ "meters";
    }
}
