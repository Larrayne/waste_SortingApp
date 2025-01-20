package com.enviro365.waste_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enviro365.waste_management.model.WasteCategory;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long>{
}
