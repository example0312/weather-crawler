package org.cnu.realcoding.weathercrawler.service;

import org.cnu.realcoding.weathercrawler.api.AvailableCityNamesApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    private AvailableCityNamesApiClient availableCityNamesApiClient;
}
