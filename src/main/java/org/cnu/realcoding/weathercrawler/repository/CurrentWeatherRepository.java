package org.cnu.realcoding.weathercrawler.repository;

import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public CurrentWeather insertOrUpdatedCurrentWeather(CurrentWeather currentWeather) {
        return mongoTemplate.save(currentWeather);
    }

    public CurrentWeather findCurrentWeatherByCityName(String cityName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(cityName));

        return mongoTemplate.findOne(query, CurrentWeather.class);
    }
}
