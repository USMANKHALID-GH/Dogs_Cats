package org.usman.dogs_cats.service.implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.usman.dogs_cats.repository.BreedRepository;
import org.usman.dogs_cats.service.BreedService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@DataJpaTest
class CatImpTest {
    @Mock
   private BreedRepository breedRepository;
   private BreedImp breedService;
 AutoCloseable cloneable;
    @BeforeEach
    void setUp() {
      cloneable=MockitoAnnotations.openMocks(this);
        breedService= new BreedImp(breedRepository);
    }

      @AfterEach
      void tearDown() throws Exception {
       cloneable.close();
      }

 @Disabled
    @Test
    void createCat() {

    }
//
//    @Test
//    void showAllcat() {
//     breedService.showAllBreed(Pageable.unpaged());
//     verify(breedRepository).findAll();
//    }

    @Disabled
    @Test
    void showAllCatNotAvailable() {
    }

    @Disabled
    @Test
    void findByCatByBreedName() {
    }

    @Disabled
    @Test
    void findByCatId() {
    }

    @Disabled
    @Test
    void updateCat() {
    }

    @Disabled
    @Test
    void deleteCatById() {
    }

    @Disabled
    @Test
    void findAllCatAndDogByAvailability() {
    }

    @Disabled
    @Test
    void findCatBysearchingInDescription() {
    }
}