package com.example.Surabi.repository;

import com.example.Surabi.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    @Query("SELECT SUM(b.totalAmount) FROM Bill b WHERE MONTH(b.date) = MONTH(CURRENT_DATE)")
    double getTotalSalesForMonth();

}