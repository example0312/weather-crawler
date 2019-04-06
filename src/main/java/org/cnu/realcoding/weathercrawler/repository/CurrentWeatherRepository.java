package org.cnu.realcoding.weathercrawler.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
}
