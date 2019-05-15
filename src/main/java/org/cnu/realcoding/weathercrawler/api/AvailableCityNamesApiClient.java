package org.cnu.realcoding.weathercrawler.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AvailableCityNamesApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String availableCitiesUri = "http://demo6468405.mockable.io/weather-crawlers/cities";
    private final ParameterizedTypeReference<List<String>> responseType = new ParameterizedTypeReference<List<String>>() {};

    public List<String> getAvailableCityNames() {
        List<String> responseBody = restTemplate.exchange(availableCitiesUri, HttpMethod.GET, null, responseType)
                .getBody();
        return responseBody;
    }
}
