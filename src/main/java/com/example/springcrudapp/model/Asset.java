package com.example.springcrudapp.model;

import com.example.springcrudapp.model.DTO.AssetDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Asset {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private double value;

    @ManyToOne
    @JsonIgnore
    private Company company;

    public Asset() {
    }

    public Asset(AssetDTO assetDTO) {
        name = assetDTO.getName();
        value = assetDTO.getValue();
    }
}
