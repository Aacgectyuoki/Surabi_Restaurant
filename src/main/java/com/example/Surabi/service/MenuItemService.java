package com.example.Surabi.service;

import com.example.Surabi.model.MenuItem;
import com.example.Surabi.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> findAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public Optional<MenuItem> findMenuItemById(Long id) {
        return menuItemRepository.findById(id);
    }

    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}
