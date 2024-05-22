package com.example.booking.repositories;

import com.example.booking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findById(long id);

    boolean existsByEmail(String email);
}