package com.enviro365.waste_management.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Guideline is mandatory")
    private String description;


    public DisposalGuideline() {}

    



    public DisposalGuideline(Long id, String description) {
        this.id = id;
        this.description = description;
    }


    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

   

    public String getDescription(){
        return description;
    }

    public void setDescription(String descripton){
        this.description = description;
    }

    @Override
    public String toString() {
        return "DisposalGuideline{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
