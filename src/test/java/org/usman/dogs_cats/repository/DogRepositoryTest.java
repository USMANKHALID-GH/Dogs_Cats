package org.usman.dogs_cats.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.usman.dogs_cats.model.Breed;
import org.usman.dogs_cats.model.Dog;

import java.time.LocalDate;
import  java.time.LocalDate.*;


@Slf4j
@DataJpaTest
class DogRepositoryTest {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private  BreedRepository breedRepository;
    private Breed breed;
    @BeforeEach
    void setUp() {
        breed = new  Breed(1L,"nono");
        breedRepository.save(breed);
    }

    @Test
    void findDogsByBreedNameIgnoreCase() {

        Dog dog = Dog.builder()
                .availability(true)
                .breed(breed)
                .dogName("nothing")
                //.birthYear(new LocalDate(2020,9,23))
                .id(2l)
                .description("this and that")
                .image("qwqw")
                .price(200f)

                .build();
        dogRepository.save(dog);
        Dog dog1=dogRepository.findDogsByBreedNameIgnoreCase(Pageable.unpaged(),"nono").getContent().get(0);

        log.info(dog1.toString());


    }
}









