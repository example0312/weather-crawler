package org.cnu.realcoding.weathercrawler.api;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AvailableCityNamesApiClient {
    private RestTemplate restTemplate;
}
