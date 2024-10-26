# weather-monitoring
Weather Monitoring Application
The Weather Monitoring application fetches, stores, and provides weather data summaries for specified cities. It uses the OpenWeatherMap API to retrieve data and stores it in an H2 database for easy access and analysis.

Features
Weather Data Fetching: Retrieves live weather data from the OpenWeatherMap API.
Database Storage: Stores weather information in an embedded H2 database.
Daily Summaries: Provides daily weather summaries for easy monitoring.
Temperature Alerts: Triggers alerts based on a specified temperature threshold.


Technologies Used
Java 17
Spring Boot 3.0.0
H2 Database
OpenWeatherMap API
JUnit and Mockito for testing


Setup Instructions
Prerequisites
Java 17 and Maven installed on your system.
An OpenWeatherMap API Key.

Configuration
Add your OpenWeatherMap API key to src/main/resources/application.properties:weather.api.key=YOUR_API_KEY


Build and Run
mvn clean install
mvn spring-boot:run

API Endpoints
Base URL
All endpoints are available at: http://localhost:8081/api/weather

Endpoints

1. Fetch and Save Weather Data
   Endpoint:/fetch
   Method: POST
   Params: city (optional)
   
2. Get Daily Summary
   Endpoint: /summary
   Method: GET
   Params: city (optional)

3. Alert for Temperature Threshold
   Endpoint: /alert
   Method: GET
   Params: city, threshold

  Project Structure
  weather-monitoring/
├── src/
│   ├── main/java/com/weather/monitoring/
│   │   ├── controller/
│   │   ├── model/
│   │   ├── repository/
│   │   ├── service/
│   │   └── WeatherMonitoringApplication.java
├── src/main/resources/
│   └── application.properties
└── README.md



