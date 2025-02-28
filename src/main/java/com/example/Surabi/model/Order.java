package com.example.Surabi.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "orders")
public class Order {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    private int quantity;

    public void setId(Long id) {
        this.id = id;
    }

}