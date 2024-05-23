package com.example.springcrudapp.service;

import com.example.springcrudapp.model.*;
import com.example.springcrudapp.repository.AddressRepository;
import com.example.springcrudapp.repository.AssetRepository;
import com.example.springcrudapp.repository.CompanyRepository;
import com.example.springcrudapp.repository.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final AssetRepository assetRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public CompanyService(CompanyRepository companyRepository, AddressRepository addressRepository,
                          CustomerRepository customerRepository, AssetRepository assetRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.assetRepository = assetRepository;
    }

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company save(Company company) {
        company.setId(null);
        return companyRepository.save(company);
    }
}
