package org.usman.dogs_cats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.usman.dogs_cats.model.User;

import java.util.Optional;
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByUserEmail(String email);
}
