package org.cnu.realcoding.weathercrawler.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.cnu.realcoding.weathercrawler.api.OpenWeatherMapApiClient;
import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.cnu.realcoding.weathercrawler.repository.CurrentWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class WeatherService {
    @Autowired
    private OpenWeatherMapApiClient openWeatherMapApiClient;
    @Autowired
    private CurrentWeatherRepository currentWeatherRepository;
    private LinkedList<String> cityNamesQueue = new LinkedList<>();

    public List<String> getAvailableCityNames() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("availableCityNames");
        InputStream inputStream = classPathResource.getInputStream();
        File availableCityNamesFile = File.createTempFile("availableCityNames", "");
        try {
            FileUtils.copyInputStreamToFile(inputStream, availableCityNamesFile);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(availableCityNamesFile, new TypeReference<List<String>>() {
        });
    }

    @Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
    public void getCurrentWeatherPeriodicallyByCityName() throws IOException {
        if (cityNamesQueue.isEmpty()) {
            List<String> availableCityNames = this.getAvailableCityNames();
            cityNamesQueue.addAll(availableCityNames);
        }

        String cityName = cityNamesQueue.pop();
        cityNamesQueue.add(cityName);

        CurrentWeather currentWeather = openWeatherMapApiClient.getCurrentWeather(cityName);

        CurrentWeather currentWeatherFromDb = currentWeatherRepository.findCurrentWeatherByCityName(cityName);

        if (currentWeatherFromDb == null || currentWeatherFromDb.getDt() != currentWeather.getDt()) {
            CurrentWeather insertedOrUpdatedCurrentWeather = currentWeatherRepository.insertOrUpdatedCurrentWeather(currentWeather);
            log.info("CurrentWeather has inserted or updated successfully. CurrentWeather : {}", insertedOrUpdatedCurrentWeather);
        }
    }

    public CurrentWeather getCurrentWeatherByCityName(String cityName) {
        return currentWeatherRepository.findCurrentWeatherByCityName(cityName);
    }
}
