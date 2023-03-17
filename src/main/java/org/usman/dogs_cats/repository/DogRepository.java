package org.usman.dogs_cats.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.usman.dogs_cats.model.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog,Long> {

    @Query("from Dog  d where  d.breed.breedName=:name")
    Page<Dog>  findDogsByBreedNameIgnoreCase(Pageable pageable,@Param("name") String name);


    Page<Dog>  findDogsByDescriptionContainingIgnoreCase(Pageable pageable,String string);
}
