package org.cnu.realcoding.weathercrawler.controller;

import org.cnu.realcoding.weathercrawler.domain.Dog;
import org.cnu.realcoding.weathercrawler.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;

    @PostMapping("/dogs")
    public void insertDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }
}
