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

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "menuItem")
    private Set<Order> orders;

    public void setId(Long id) {
        this.id = id;
    }
}
