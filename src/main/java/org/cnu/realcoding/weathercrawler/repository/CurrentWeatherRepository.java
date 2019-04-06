package org.cnu.realcoding.weathercrawler.repository;

import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public CurrentWeather insertCurrentWeather(CurrentWeather currentWeather) {
        return mongoTemplate.insert(currentWeather);
    }
}
