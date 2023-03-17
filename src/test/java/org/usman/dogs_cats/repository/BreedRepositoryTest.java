package org.usman.dogs_cats.repository;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.usman.dogs_cats.model.Breed;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Slf4j
@DataJpaTest
class BreedRepositoryTest {

    @Autowired
     BreedRepository breedRepository;



    @Test
    void findBreadByBreedNameIgnoreCase() {
//        Given
        Breed breed = new  Breed(1L,"nono");
        breedRepository.save(breed);
//        then
        Optional<Breed> breedOptional=breedRepository.findBreadByBreedNameIgnoreCase("nono");

        log.info(breedOptional.get().toString());

        assertThat(breedOptional.get().getBreedName()).isEqualTo(breed.getBreedName());

    }


}