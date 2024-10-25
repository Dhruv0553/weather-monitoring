package com.weather.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.weather.service")  // Make sure it includes the service package
public class WeatherMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherMonitoringApplication.class, args);
    }
}
