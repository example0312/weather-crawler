package org.cnu.realcoding.weathercrawler.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AvailableCityNamesApiClient {
    @Autowired
    private RestTemplate restTemplate;

    public List<String> getAvilableCityNames() {
        return null;
    }
}
