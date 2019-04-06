package org.cnu.realcoding.weathercrawler.service;

import lombok.extern.slf4j.Slf4j;
import org.cnu.realcoding.weathercrawler.api.AvailableCityNamesApiClient;
import org.cnu.realcoding.weathercrawler.api.OpenWeatherMapApiClient;
import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.cnu.realcoding.weathercrawler.repository.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
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

    @Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
    public void getCurrentWeatherPeriodicallyByCityName() {
        if (cityNamesQueue.isEmpty()) {
            List<String> availableCityNames = this.getAvailableCityNames();
            cityNamesQueue.addAll(availableCityNames);
        }

        String cityName = cityNamesQueue.pop();
        cityNamesQueue.add(cityName);

        CurrentWeather currentWeather = openWeatherMapApiClient.getCurrentWeather(cityName);

        CurrentWeather insertedCurrentWeather = currentWeatherRepository.insertCurrentWeather(currentWeather);
        log.info("CurrentWeather has inserted successfully. CurrentWeather : {}", insertedCurrentWeather);
    }

    public CurrentWeather getCurrentWeatherByCityName(String cityName) {
        return currentWeatherRepository.findRecentCurrentWeatherByCityName(cityName);
    }
}
