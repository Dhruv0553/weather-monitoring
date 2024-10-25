package com.weather.repository;

import com.weather.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {	
}
