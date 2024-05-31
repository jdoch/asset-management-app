package com.example.springcrudapp.model;

import com.example.springcrudapp.model.DTO.CustomerDTO;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
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

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Address address;

    @ManyToMany
    @JsonIgnoreProperties({"customers", "assets", "address"})
    private Set<Company> companies = new HashSet<>();

    public Customer() {
    }

    public Customer(CustomerDTO customerDTO) {
        name = customerDTO.getName();
        surname = customerDTO.getSurname();
        address = new Address(customerDTO.getAddress());
        companies = new HashSet<>(customerDTO.getCompanies());
    }

    public void addCompany(Company company) {
        companies.add(company);
        company.getCustomers().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id != null && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
