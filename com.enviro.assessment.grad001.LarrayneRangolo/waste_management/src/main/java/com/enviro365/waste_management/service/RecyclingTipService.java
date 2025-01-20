package com.enviro365.waste_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enviro365.waste_management.model.RecyclingTip;
import com.enviro365.waste_management.repository.RecyclingTipRepository;


@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTip> getAllRecyclingTips() {
        return repository.findAll();
    }

    public RecyclingTip getRecyclingTipById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recycling tip with ID " + id + " not found."));
    }

    public RecyclingTip addRecyclingTip(RecyclingTip tip) {
        return repository.save(tip);
    }

    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip updatedTip) {
        RecyclingTip existingTip = getRecyclingTipById(id);
        existingTip.setTip(updatedTip.getTip());
        return repository.save(existingTip);
    }

    public void deleteRecyclingTip(Long id) {
        RecyclingTip tip = getRecyclingTipById(id);
        repository.delete(tip);
    }
}
