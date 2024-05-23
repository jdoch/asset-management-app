package com.example.springcrudapp.service;

import com.example.springcrudapp.dto.CustomerDTO;
import com.example.springcrudapp.exception.CustomerNotFound;
import com.example.springcrudapp.model.Address;
import com.example.springcrudapp.model.Customer;
import com.example.springcrudapp.repository.AddressRepository;
import com.example.springcrudapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());

        Address address = customerDTO.getAddress();
        if (address != null) {
            customer.setAddress(address);
            addressRepository.save(address);
        }
        return customerRepository.save(customer);
    }

    public Customer update(UUID id, Customer updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerNotFound::new);
        customer.setName(updatedCustomer.getName());
        customer.setSurname(updatedCustomer.getSurname());
        return customerRepository.save(customer);
    }

    public void delete(UUID id) {
        if (customerRepository.findById(id).isEmpty()) {
            throw new CustomerNotFound();
        }
        customerRepository.deleteById(id);
    }
}
