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

import com.enviro365.waste_management.model.DisposalGuideline;
import com.enviro365.waste_management.service.DisposalGuidelineService;


@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService service;

    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return service.findAll();
    }

    @GetMapping("/{id}")
public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
    DisposalGuideline guideline = service.findById(id);
    if (guideline != null) {
        return ResponseEntity.ok(guideline);
    } else {
        return ResponseEntity.notFound().build();
    }
}


    @PostMapping
    public DisposalGuideline createDisposalGuideline(@Validated @RequestBody DisposalGuideline guideline) {
        return service.save(guideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateGuideline(@PathVariable Long id, @Validated @RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline updatedGuideline = service.update(id, disposalGuideline);

        return ResponseEntity.status(HttpStatus.OK).body(updatedGuideline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        service.deleteById(id);  // Calls the service method to delete by ID
        return ResponseEntity.noContent().build();  // Returns 204 No Content response
    }
}

