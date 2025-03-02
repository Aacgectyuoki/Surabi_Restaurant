package com.example.Surabi.service;

import com.example.Surabi.model.Bill;
import com.example.Surabi.model.User;
import com.example.Surabi.repository.BillRepository;
import com.example.Surabi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Bill> findAllBills() {
        return billRepository.findAll();
    }

    public Optional<Bill> findBillById(Long id) {
        return billRepository.findById(id);
    }

    public Bill saveBill(Bill bill) {
        return billRepository.save(bill);
    }

    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

    public List<Bill> getBillsGeneratedToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startOfDay = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date endOfDay = calendar.getTime();

        return billRepository.findByCreatedAtBetween(startOfDay, endOfDay);
    }

    public double getTotalSalesForMonth() {
        return billRepository.findAll().stream()
                .mapToDouble(Bill::getTotalAmount)
                .sum();
    }

    public Bill getFinalBill(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return billRepository.findTopByUserOrderByCreatedAtDesc(user)
                .orElseThrow(() -> new RuntimeException("No bill found for user"));
    }
}
