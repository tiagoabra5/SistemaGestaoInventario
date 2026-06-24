package com.tiago.Sistema.repository;

import com.tiago.Sistema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameContainingIgnoreCase(String name);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}