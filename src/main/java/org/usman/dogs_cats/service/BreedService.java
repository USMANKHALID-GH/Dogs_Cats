package org.usman.dogs_cats.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.usman.dogs_cats.model.Breed;


public interface BreedService {

    void createBreed(Breed breed);

    Page<Breed> showAllBreed(Pageable pageable);

    Breed findByBreedName(String name);

    Breed findById(Long _long);

    void updateBreed(Long id, Breed breed);

    void deleteBreedById(Long id);
}
