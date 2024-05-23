package com.example.springcrudapp.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Address address;

    @ManyToMany
    @JsonIgnoreProperties({"customers", "assets", "address"})
    private Set<Company> companies = new HashSet<>();
}
