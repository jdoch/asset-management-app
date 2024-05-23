package com.example.springcrudapp.service;

import com.example.springcrudapp.model.*;
import com.example.springcrudapp.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company save(Company company) {
        company.setId(null);
        return companyRepository.save(company);
    }
}
