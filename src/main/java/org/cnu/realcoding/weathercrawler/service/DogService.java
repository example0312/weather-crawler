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

    public List<Dog> getAllDogs() {
        return dogList;
    }

    public Dog getDogsByName(String name) {
        for (int i = 0; i < dogList.size(); i++) {
            Dog target = dogList.get(i);
            if (target.getName().equals(name)) {
                return target;
            }
        }
        return null;
    }

    public void updateDog(Dog dog) {
        for (int i = 0; i < dogList.size(); i++) {
            Dog target = dogList.get(i);
            if (target.getName().equals(dog.getName())) {
                target.setKind(dog.getKind());
                break;
            }
        }
    }

    public void removeDog(String name) {
        for (int i = 0; i < dogList.size(); i++) {
            Dog target = dogList.get(i);
            if (target.getName().equals(name)) {
                dogList.remove(target);
                break;
            }
        }
    }
}
