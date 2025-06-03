package com.example.springcrudapp.service;

import com.example.springcrudapp.exception.CompanyNotFound;
import com.example.springcrudapp.model.*;
import com.example.springcrudapp.model.DTO.AddressDTO;
import com.example.springcrudapp.model.DTO.CompanyDTO;
import com.example.springcrudapp.model.DTO.CompanyListEntryDTO;
import com.example.springcrudapp.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<CompanyListEntryDTO> findAll(int pageNumber, int pageSize) {
        return companyRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("name")))
                .stream()
                .map(CompanyListEntryDTO::new)
                .collect(Collectors.toList());
    }

    public long count() {
        return companyRepository.count();
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

    @Transactional
    public void delete(UUID id) {
        if (!companyRepository.existsById(id)) {
            throw new CompanyNotFound();
        }
        companyRepository.deleteById(id);
    }

    private void updateCompanyAddress(Company company, AddressDTO updatedAddress) {
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
