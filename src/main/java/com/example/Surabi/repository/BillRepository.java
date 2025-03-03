package com.example.Surabi.repository;

import com.example.Surabi.model.Bill;
import com.example.Surabi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    // Find all bills associated with a specific user ID
    List<Bill> findByUserId(Long userId);

    // Find all bills within a specific date range
    List<Bill> findByCreatedAtBetween(Date startDate, Date endDate);

    //Get the most recent bill for a user.
    Optional<Bill> findTopByUserOrderByCreatedAtDesc(User user);
}
