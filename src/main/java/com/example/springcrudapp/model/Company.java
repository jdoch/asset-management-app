package com.example.springcrudapp.model;

import com.example.springcrudapp.model.DTO.CompanyDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    @ManyToMany(mappedBy = "companies")
    @JsonIgnoreProperties({"companies", "address"})
    private Set<Customer> customers = new HashSet<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Asset> assets = new ArrayList<>();

    public Company() {
    }

    public Company(CompanyDTO companyDto) {
        name = companyDto.getName();
        address = companyDto.getAddress();
        customers = companyDto.getCustomers();
        assets = companyDto.getAssets();
    }
}
