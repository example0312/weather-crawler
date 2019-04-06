package org.cnu.realcoding.weathercrawler.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AvailableCityNamesApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String availableCitiesUri = "http://demo6468405.mockable.io/weather-crawlers/cities";

    public List<String> getAvilableCityNames() {
        String[] responseBody = restTemplate.exchange(availableCitiesUri, HttpMethod.GET, null, String[].class)
                .getBody();
        return null;
    }
}
