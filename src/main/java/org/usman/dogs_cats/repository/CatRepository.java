package org.usman.dogs_cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.usman.dogs_cats.model.Cat;
@Repository
public interface CatRepository  extends JpaRepository<Cat, Long> {
}
