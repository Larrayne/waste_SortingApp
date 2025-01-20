package com.enviro365.waste_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro365.waste_management.model.WasteCategory;
import com.enviro365.waste_management.repository.WasteCategoryRepository;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("WasteCategory not found"));
    }

    public WasteCategory save(WasteCategory category) {
        return repository.save(category);
    }

    public void deleteById(Long id) {
        WasteCategory category = getWasteCategoryById(id);
        repository.delete(category);
    }
}
