package org.cnu.realcoding.weathercrawler.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "b59b2f6b4c62b33a007db6708713d1e6";
    private final String currentWeatherUri = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&APPID={apiKey}";

    public String getCurrentWeather(String cityName) {
        String currentWeather = restTemplate.exchange(currentWeatherUri, HttpMethod.GET, null, String.class, cityName, apiKey)
                .getBody();
        return currentWeather;
    }
}
