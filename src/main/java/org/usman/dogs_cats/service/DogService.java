package org.usman.dogs_cats.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.usman.dogs_cats.model.Dog;

import java.util.List;

public interface DogService {
    void createDog(Dog toEntity);

    List<Dog> showAllBreed(Pageable pageable);

    Page<Dog> findByDogByBreedName(Pageable pageable,String name);

    Dog findByDogId(Long id);

    void updateDog(Long id, Dog dog);

    void deleteDogById(Long id);

    void updatePrice(Long id, Dog dog);

    void buyPrice(Long id);

    void updateAvailability(Long id, Dog dog);

    List<Dog> showAllDogNotAvailable(Pageable pageable);

    Page<Dog> findDogBysearchingInDescription(Pageable pageable,String string);
}
