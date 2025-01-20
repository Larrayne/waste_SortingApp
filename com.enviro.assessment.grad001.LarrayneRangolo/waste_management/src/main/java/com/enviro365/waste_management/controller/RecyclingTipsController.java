package com.enviro365.waste_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.enviro365.waste_management.model.RecyclingTip;
import com.enviro365.waste_management.service.RecyclingTipService;


@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipsController {

    private final RecyclingTipService service;

    @Autowired
    public RecyclingTipsController(RecyclingTipService service) {
        this.service = service;
    }

    @GetMapping
public List<RecyclingTip> getAllRecyclingTips() {
    return service.getAllRecyclingTips();
}

@GetMapping("/{id}")
public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
    RecyclingTip tip = service.getRecyclingTipById(id);
    return ResponseEntity.ok(tip);
}

@PostMapping
public RecyclingTip addRecyclingTip(@Validated @RequestBody RecyclingTip recyclingTip) {
    return service.addRecyclingTip(recyclingTip);
}

@PutMapping("/{id}")
public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @Validated @RequestBody RecyclingTip recyclingTip) {
    RecyclingTip updatedTip = service.updateRecyclingTip(id, recyclingTip);
    return ResponseEntity.ok(updatedTip);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
    service.deleteRecyclingTip(id);
    return ResponseEntity.noContent().build();
}

}
