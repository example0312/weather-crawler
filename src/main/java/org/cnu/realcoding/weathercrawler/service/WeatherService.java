package org.cnu.realcoding.weathercrawler.service;

import org.cnu.realcoding.weathercrawler.api.AvailableCityNamesApiClient;
import org.cnu.realcoding.weathercrawler.api.OpenWeatherMapApiClient;
import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private AvailableCityNamesApiClient availableCityNamesApiClient;
    @Autowired
    private OpenWeatherMapApiClient openWeatherMapApiClient;
    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;

    private LinkedList<String> cityNamesQueue = new LinkedList<>();

    public List<String> getAvailableCityNames() {
        List<String> availableCityNames = availableCityNamesApiClient.getAvailableCityNames();
        return availableCityNames;
    }

    public void getCurrentWeatherPeriodicallyByCityName() {
        if (cityNamesQueue.isEmpty()) {
            List<String> availableCityNames = this.getAvailableCityNames();
            cityNamesQueue.addAll(availableCityNames);
        }

        String cityName = cityNamesQueue.pop();
        cityNamesQueue.add(cityName);

        CurrentWeather currentWeather = openWeatherMapApiClient.getCurrentWeather(cityName);
    }
}
