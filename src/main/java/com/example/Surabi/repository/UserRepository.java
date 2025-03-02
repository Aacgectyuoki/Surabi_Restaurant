package com.example.Surabi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Surabi.model.User;

import com.example.Surabi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom database queries here if needed
}
