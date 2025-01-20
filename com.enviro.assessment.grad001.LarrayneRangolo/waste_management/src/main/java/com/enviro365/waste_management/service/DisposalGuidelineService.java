package com.enviro365.waste_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro365.waste_management.model.DisposalGuideline;
import com.enviro365.waste_management.repository.DisposalGuidelineRepository;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuideline> findAll() {
        List<DisposalGuideline> guidelines = repository.findAll();
        if (guidelines.isEmpty()) {
            throw new RuntimeException("No disposal guidelines found.");
        }
        return guidelines;
    }

    public DisposalGuideline findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disposal guideline with ID " + id + " not found."));
    }

    public DisposalGuideline save(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    public DisposalGuideline update(Long id, DisposalGuideline updatedGuideline) {
        DisposalGuideline existingGuideline = findById(id);
        existingGuideline.setDescription(updatedGuideline.getDescription());  // Fixed to use 'description'
        return repository.save(existingGuideline);
    }

    public void deleteById(Long id) {
        DisposalGuideline guideline = findById(id);
        repository.delete(guideline);
    }
}
