package com.example.springcrudapp.service;

import com.example.springcrudapp.model.DTO.AddressDTO;
import com.example.springcrudapp.model.DTO.CompanyListEntryDTO;
import com.example.springcrudapp.model.DTO.CustomerDTO;
import com.example.springcrudapp.exception.CustomerNotFound;
import com.example.springcrudapp.model.Address;
import com.example.springcrudapp.model.Customer;
import com.example.springcrudapp.model.DTO.CustomerListEntryDTO;
import com.example.springcrudapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerListEntryDTO> findAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(CustomerListEntryDTO::new)
                .collect(Collectors.toList());
    }

    public Customer findById(UUID id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFound::new);
    }

    public Customer save(CustomerDTO customerDTO) {
        return customerRepository.save(new Customer(customerDTO));
    }

    @Transactional
    public Customer update(UUID id, CustomerDTO updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFound::new);
        customer.setName(updatedCustomer.getName());
        customer.setSurname(updatedCustomer.getSurname());
        updateCustomerAddress(customer, updatedCustomer.getAddress());
        return customer;
    }

    @Transactional
    public void delete(UUID id) {
        if (customerRepository.existsById(id)) {
            throw new CustomerNotFound();
        }
        customerRepository.deleteById(id);
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
}
