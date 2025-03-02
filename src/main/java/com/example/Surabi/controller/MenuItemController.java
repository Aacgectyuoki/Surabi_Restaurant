package com.example.Surabi.controller;

import com.example.Surabi.model.MenuItem;
import com.example.Surabi.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menuItems")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    // As a user, I should be able to see all items available along with the price.
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllMenuItems() {
        return ResponseEntity.ok(menuItemService.findAllMenuItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Long id) {
        return menuItemService.findMenuItemById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // As an admin, I should be able to perform CRUD on menu and menu items (Create).
    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
        return ResponseEntity.ok(menuItemService.saveMenuItem(menuItem));
    }

    // As an admin, I should be able to perform CRUD on menu and menu items (Update).
    @PutMapping("/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) {
        return menuItemService.findMenuItemById(id)
                .map(existingItem -> {
                    menuItem.setId(id);
                    return ResponseEntity.ok(menuItemService.saveMenuItem(menuItem));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // As an admin, I should be able to perform CRUD on menu and menu items (Delete).
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenuItem(@PathVariable Long id) {
        return menuItemService.findMenuItemById(id)
                .map(item -> {
                    menuItemService.deleteMenuItem(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
