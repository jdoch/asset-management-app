package com.example.springcrudapp.service;

import com.example.springcrudapp.exception.CompanyNotFound;
import com.example.springcrudapp.model.*;
import com.example.springcrudapp.model.DTO.CompanyDTO;
import com.example.springcrudapp.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company save(CompanyDTO companyDto) {
        return companyRepository.save(new Company(companyDto));
    }

    @Transactional
    public Company update(UUID id, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(id).orElseThrow(CompanyNotFound::new);
        company.setName(companyDTO.getName());
        updateCompanyAddress(company, companyDTO.getAddress());
        return company;
    }

    private void updateCompanyAddress(Company company, Address updatedAddress) {
        Address address = company.getAddress();
        if (address == null) {
            address = new Address();
            company.setAddress(address);
        }

        if (updatedAddress != null) {
            address.setStreet(updatedAddress.getStreet());
            address.setPostalCode(updatedAddress.getPostalCode());
            address.setBuildingNumber(updatedAddress.getBuildingNumber());
            address.setHouseNumber(updatedAddress.getHouseNumber());
        }
    }

}
