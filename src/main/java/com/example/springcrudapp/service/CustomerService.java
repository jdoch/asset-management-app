package com.example.springcrudapp.service;

import com.example.springcrudapp.model.DTO.CustomerDTO;
import com.example.springcrudapp.exception.CustomerNotFound;
import com.example.springcrudapp.model.Address;
import com.example.springcrudapp.model.Customer;
import com.example.springcrudapp.repository.AddressRepository;
import com.example.springcrudapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
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

    private void updateCustomerAddress(Customer customer, Address updatedAddress) {
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
