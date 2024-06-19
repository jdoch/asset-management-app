package com.example.springcrudapp.service;

import com.example.springcrudapp.exception.CompanyNotFound;
import com.example.springcrudapp.model.Company;
import com.example.springcrudapp.model.DTO.AddressDTO;
import com.example.springcrudapp.model.DTO.CustomerDTO;
import com.example.springcrudapp.exception.CustomerNotFound;
import com.example.springcrudapp.model.Address;
import com.example.springcrudapp.model.Customer;
import com.example.springcrudapp.model.DTO.CustomerListEntryDTO;
import com.example.springcrudapp.repository.CompanyRepository;
import com.example.springcrudapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;

    public List<CustomerListEntryDTO> findAll(int pageNumber, int pageSize) {
        return customerRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("name")))
                .stream()
                .map(CustomerListEntryDTO::new)
                .collect(Collectors.toList());
    }

    public Customer findById(UUID id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFound::new);
    }

    public Customer save(CustomerDTO customerDTO) {
        validateCustomer(customerDTO);
        Customer customer = new Customer(customerDTO);
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer update(UUID id, CustomerDTO updatedCustomer) {
        validateCustomer(updatedCustomer);
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFound::new);
        customer.setName(updatedCustomer.getName());
        customer.setSurname(updatedCustomer.getSurname());
        updateCustomerAddress(customer, updatedCustomer.getAddress());
        updateCustomerCompanies(customer, updatedCustomer.getCompanies());
        return customer;
    }

    @Transactional
    public void delete(UUID id) {
        if (customerRepository.existsById(id)) {
            throw new CustomerNotFound();
        }
        customerRepository.deleteById(id);
    }

    private void validateCustomer(CustomerDTO customerDTO) {
        var companies = customerDTO.getCompanies();
        if (companies == null)  {
            return;
        }
        var companyIds = companies.stream()
                .map(Company::getId)
                .toList();
        if (!companies.isEmpty() && !companyRepository.existsAllByIdIn(companyIds)) {
            throw new CompanyNotFound();
        }
    }

    private void updateCustomerAddress(Customer customer, AddressDTO updatedAddress) {
        Address address = customer.getAddress();
        if (address == null) {
            address = new Address();
            customer.setAddress(address);
        }

        if (updatedAddress != null) {
            address.setStreet(updatedAddress.getStreet());
            address.setPostalCode(updatedAddress.getPostalCode());
            address.setBuildingNumber(updatedAddress.getBuildingNumber());
            address.setHouseNumber(updatedAddress.getHouseNumber());
        }
    }

    private void updateCustomerCompanies(Customer customer, List<Company> companies) {
        customer.getCompanies().clear();
        if (companies != null) {
            companies.forEach(customer::addCompany);
        }
    }
}
