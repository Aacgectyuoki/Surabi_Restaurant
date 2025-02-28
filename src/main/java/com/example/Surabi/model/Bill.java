package com.example.Surabi.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "bills")
public class Bill {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private double totalAmount;
    private Date date;

    public void setId(Long id) {
        this.id = id;
    }

}
