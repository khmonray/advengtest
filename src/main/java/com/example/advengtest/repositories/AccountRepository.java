package com.example.advengtest.repositories;

import com.example.advengtest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
}
