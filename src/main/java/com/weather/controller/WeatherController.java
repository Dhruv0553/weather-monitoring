package com.weather.controller;

import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather/{city}")
    public String getWeather(@PathVariable String city) {
        weatherService.fetchAndSaveWeatherData(city);
        return "Weather data fetched and saved for " + city;
    }

    @GetMapping("/weather/summary/{city}")
    public String getWeatherSummary(@PathVariable String city) {
        return weatherService.getDailyWeatherSummary(city);
    }
}
