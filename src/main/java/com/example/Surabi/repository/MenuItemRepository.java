package com.example.Surabi.repository;

import com.example.Surabi.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    // Custom queries for menu items can be added here
}
