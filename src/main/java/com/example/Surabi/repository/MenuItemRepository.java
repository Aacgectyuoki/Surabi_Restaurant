package com.example.Surabi.repository;

import com.example.Surabi.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    // Find menu items by name (case insensitive search)
    List<MenuItem> findByNameContainingIgnoreCase(String name);

    // Find menu items by category
    List<MenuItem> findByCategory(String category);

    // Find menu items within a price range
    List<MenuItem> findByPriceBetween(Double minPrice, Double maxPrice);
}
