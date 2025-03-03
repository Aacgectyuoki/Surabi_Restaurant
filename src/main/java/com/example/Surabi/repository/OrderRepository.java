package com.example.Surabi.repository;

import com.example.Surabi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Find orders by user ID
    List<Order> findByUserId(Long userId);

    // Find all orders by user ID
    List<Order> findAllByUserId(Long userId);

    // Find all orders by menu item ID
    List<Order> findAllByMenuItemId(Long menuItemId);

    // Find orders placed within a specific date range
    List<Order> findByCreatedAtBetween(Date startDate, Date endDate);

    // Find orders by status (e.g., "PENDING", "COMPLETED", "CANCELLED")
    List<Order> findByStatus(String status);

}