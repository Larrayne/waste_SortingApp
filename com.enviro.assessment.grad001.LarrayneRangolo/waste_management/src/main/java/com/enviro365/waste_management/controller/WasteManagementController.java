package com.enviro365.waste_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro365.waste_management.model.WasteCategory;
import com.enviro365.waste_management.service.WasteCategoryService;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteManagementController {

    private final WasteCategoryService service;

    @Autowired
    public WasteManagementController(WasteCategoryService service) {
        this.service = service;
    }

    @GetMapping
public ResponseEntity<List<WasteCategory>> getAllCategories() {
    List<WasteCategory> categories = service.getAllCategories();
    return ResponseEntity.ok(categories);
}

@GetMapping("/{id}")
public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
    WasteCategory category = service.getWasteCategoryById(id);
    return ResponseEntity.ok(category);
}

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@Validated @RequestBody WasteCategory category) {
        WasteCategory createdCategory = service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @Validated @RequestBody WasteCategory category) {
        category.setId(id); // Set the ID from the path variable
        WasteCategory updatedCategory = service.save(category);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
