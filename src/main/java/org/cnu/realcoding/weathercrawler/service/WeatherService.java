package org.cnu.realcoding.weathercrawler.service;

import org.cnu.realcoding.weathercrawler.api.AvailableCityNamesApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private AvailableCityNamesApiClient availableCityNamesApiClient;

    public List<String> getAvailableCityNames() {
        List<String> avilableCityNames = availableCityNamesApiClient.getAvilableCityNames();
        return avilableCityNames;
    }
}
