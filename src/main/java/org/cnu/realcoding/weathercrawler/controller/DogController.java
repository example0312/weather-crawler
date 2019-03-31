package org.cnu.realcoding.weathercrawler.controller;

import org.cnu.realcoding.weathercrawler.domain.Dog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    @PostMapping("/dogs")
    public void insertDog(@RequestBody Dog dog) {

    }
}
