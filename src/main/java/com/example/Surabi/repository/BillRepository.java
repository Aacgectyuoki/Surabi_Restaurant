package com.example.Surabi.repository;

import com.example.Surabi.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    // Custom queries to fetch bills, like finding all bills for a specific day
}