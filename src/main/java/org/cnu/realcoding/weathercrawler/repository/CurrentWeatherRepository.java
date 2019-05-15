package org.cnu.realcoding.weathercrawler.repository;

import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public CurrentWeather insertCurrentWeather(CurrentWeather currentWeather) {
        return mongoTemplate.insert(currentWeather);
    }

    public CurrentWeather findRecentCurrentWeatherByCityName(String cityName) {
        Query query = new Query();

        query.addCriteria(Criteria.where("name").is(cityName));
        query.with(Sort.by(Sort.Order.desc("_id")));

        return mongoTemplate.findOne(query, CurrentWeather.class);
    }
}
