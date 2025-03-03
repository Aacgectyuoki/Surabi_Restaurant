package com.example.Surabi.controller;

import com.example.Surabi.model.Bill;
import com.example.Surabi.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;

    // Retrieve all bills
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.findAllBills());
    }

    // Retrieve a bill by its id
    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        return billService.findBillById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Retrieve all bills generated today
    @GetMapping("/today")
    public ResponseEntity<List<Bill>> getBillsGeneratedToday() {
        return ResponseEntity.ok(billService.getBillsGeneratedToday());
    }

    // Retrieve the total sales for the month
    @GetMapping("/monthly-sales")
    public ResponseEntity<Double> getMonthlySales() {
        return ResponseEntity.ok(billService.getTotalSalesForMonth());
    }

    // Create a new bill
    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        return ResponseEntity.ok(billService.saveBill(bill));
    }

    // Update an existing bill
    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill bill) {
        return billService.findBillById(id)
                .map(existingBill -> {
                    bill.setId(id);
                    return ResponseEntity.ok(billService.saveBill(bill));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an existing bill
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable Long id) {
        return billService.findBillById(id)
                .map(bill -> {
                    billService.deleteBill(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
