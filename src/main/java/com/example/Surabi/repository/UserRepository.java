package com.example.Surabi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Surabi.model.User;

import com.example.Surabi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find a user by username (for authentication)
    Optional<User> findByUsername(String username);

    // Check if a username exists
    boolean existsByUsername(String username);

    // Find all users by role
    List<User> findByRole(String role);
}
