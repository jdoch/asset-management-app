package com.example.springcrudapp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    /*@ManyToMany(mappedBy = "companies")
    @JsonIgnoreProperties({"companies", "address"})
    private Set<Customer> customers = new HashSet<>();*/

    @OneToMany(mappedBy = "company")
    private List<Asset> assets = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /*public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }*/

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
