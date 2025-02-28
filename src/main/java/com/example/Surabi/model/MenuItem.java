package com.example.Surabi.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "menu_items")
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @OneToMany(mappedBy = "menuItem")
    private Set<Order> orders;

    public void setId(Long id) {
        this.id = id;
    }
}
