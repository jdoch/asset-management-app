package com.example.springcrudapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    private UUID id;
    private String street;
    private String postalCode;
    private String buildingNumber;
    private String houseNumber;

    @JsonIgnore
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Company company;

    @JsonIgnore
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Customer customer;
}
