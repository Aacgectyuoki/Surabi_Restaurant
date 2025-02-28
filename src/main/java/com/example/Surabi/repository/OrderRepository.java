package com.example.Surabi.repository;

import com.example.Surabi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Example: Find orders by user ID
    List<Order> findByUserId(Long userId);
}