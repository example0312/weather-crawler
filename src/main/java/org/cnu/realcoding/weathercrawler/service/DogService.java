package org.cnu.realcoding.weathercrawler.service;

import org.cnu.realcoding.weathercrawler.domain.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogService {
    private List<Dog> dogList = new ArrayList<>();

    public void insertDog(Dog dog) {
        dogList.add(dog);
    }
}
