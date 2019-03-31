package org.cnu.realcoding.weathercrawler.controller;

import org.cnu.realcoding.weathercrawler.domain.Dog;
import org.cnu.realcoding.weathercrawler.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;

    @PostMapping("/dogs")
    public void insertDog(@RequestBody Dog dog) {
        dogService.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @GetMapping("/dogs/{name}")
    public Dog getDogByName(@PathVariable String name) {
        return dogService.getDogsByName(name);
    }

    @PutMapping("/dogs")
    public void updateDog(@RequestBody Dog dog) {
        dogService.updateDog(dog);
    }

    @DeleteMapping("/dogs")
    public void removeDog(@RequestParam String name) {
        dogService.removeDog(name);
    }
}
