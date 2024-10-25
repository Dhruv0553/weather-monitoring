package com.weather.service;

import com.weather.repository.WeatherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class WeatherServiceTest {

    private WeatherService weatherService;
    private WeatherRepository weatherRepository;

    @BeforeEach
    public void setUp() {
        weatherRepository = mock(WeatherRepository.class); // Manually mock
        weatherService = new WeatherService(weatherRepository);  // Manual injection
        weatherService.setApiKey("dummy_api_key");  // Set dummy API key
        System.out.println("weatherService: " + weatherService); // Debug output
        System.out.println("weatherRepository: " + weatherRepository); // Debug output
    }

    @Test
    public void testWeatherServiceNotNull() {
        assertNotNull(weatherService, "weatherService should be initialized");
    }
}
