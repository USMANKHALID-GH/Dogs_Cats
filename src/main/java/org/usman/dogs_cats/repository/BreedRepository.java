package org.usman.dogs_cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.usman.dogs_cats.model.Breed;

import java.util.Optional;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long> {

   Optional<Breed> findBreadByBreedNameIgnoreCase(String name);

   @Override
   Optional<Breed> findById(Long aLong);
}
