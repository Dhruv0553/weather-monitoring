package com.weather.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.model.WeatherData;
import com.weather.repository.WeatherRepository;
import com.weather.utils.WeatherUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Value("${weather.api.key}")
    private String apiKey;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    } 
    
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    
    public void fetchAndSaveWeatherData(String city) {
        try {
            String response = WeatherUtils.callWeatherAPI(apiKey, city);
            if (response == null) {
                System.err.println("Failed to fetch weather data from API.");
                return;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response);

            String mainWeather = rootNode.path("weather").get(0).path("main").asText();
            double tempInKelvin = rootNode.path("main").path("temp").asDouble();
            double feelsLikeInKelvin = rootNode.path("main").path("feels_like").asDouble();
            long timestamp = rootNode.path("dt").asLong();

            double tempInCelsius = WeatherUtils.convertKelvinToCelsius(tempInKelvin);
            double feelsLikeInCelsius = WeatherUtils.convertKelvinToCelsius(feelsLikeInKelvin);

            WeatherData weatherData = new WeatherData();
            weatherData.setMain(mainWeather);
            weatherData.setTemp(tempInCelsius);
            weatherData.setFeelsLike(feelsLikeInCelsius);
            weatherData.setTimestamp(timestamp);

            weatherRepository.save(weatherData);
            System.out.println("Weather data saved successfully for " + city);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDailyWeatherSummary(String city) {
        return "Daily Summary for " + city + ": ...";
    }
}
