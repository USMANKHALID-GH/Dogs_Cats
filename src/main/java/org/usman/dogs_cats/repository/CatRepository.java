package org.usman.dogs_cats.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.usman.dogs_cats.model.Cat;


@Repository
public interface CatRepository  extends JpaRepository<Cat, Long> {

    @Query("from Cat  c where  c.breed.breedName=:name")
    Page<Cat> findCatsByBreedNameIgnoreCase(Pageable pageable, @Param("name") String name);

    @Query(value = """
   select cat_name, description ,image, price from cat_tbl where availability=1
   union
   select dog_name, description ,image, price from dog_tbl where availability=1;
    """ , nativeQuery = true )
    Page<Object>  findAllCatAndDogByAvailability(Pageable pageable  );

Page<Cat>   findCatByDescriptionContainingIgnoreCase(Pageable pageable, String string);



}
