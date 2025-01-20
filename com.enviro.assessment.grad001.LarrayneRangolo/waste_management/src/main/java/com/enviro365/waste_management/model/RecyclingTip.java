package com.enviro365.waste_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tip is needed")
    private String tip;

    // Default constructor
    public RecyclingTip() {}

    // Parameterized constructor
    public RecyclingTip(Long id, String tip) {
        this.id = id;
        this.tip = tip;
    }

    // Getter for ID
    public Long getId() {
        return id;
    }

    // Setter for ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for Tip
    public String getTip() {
        return tip;
    }

    // Setter for Tip
    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "RecyclingTip{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                '}';
    }
}
