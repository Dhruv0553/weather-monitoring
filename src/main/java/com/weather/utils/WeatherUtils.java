package com.weather.utils;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.http.ResponseEntity;

public class WeatherUtils {

    public static String callWeatherAPI(String apiKey, String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.err.println("Error: Unable to fetch weather data. HTTP Status: " + e.getStatusCode());
            return null;
        } catch (ResourceAccessException e) {
            System.err.println("Error: Unable to access the weather API. Check your network connection.");
            return null;
        } catch (Exception e) {
            System.err.println("Error: An unexpected error occurred while fetching weather data.");
            e.printStackTrace();
            return null;
        }
    }

    public static double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double convertKelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }
}
