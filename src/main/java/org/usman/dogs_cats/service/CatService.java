package org.usman.dogs_cats.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.query.Param;
import org.usman.dogs_cats.model.Cat;

import java.util.List;

public interface CatService {
    void createCat(Cat toEntity);

    List<Cat> showAllcat(Pageable pageable);

    List<Cat> showAllCatNotAvailable(Pageable pageable);

    Page<Cat> findByCatByBreedName(Pageable pageable, String name);

    Cat findByCatId(Long id);

    void updateCat(Long id, Cat toEntity);

    void deleteCatById(Long id);

    Page<Object>  findAllCatAndDogByAvailability(Pageable pageable  );
}
