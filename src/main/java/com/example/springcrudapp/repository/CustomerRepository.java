package com.example.springcrudapp.repository;

import com.example.springcrudapp.model.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {
    List<Customer> findAll(Pageable pageable);
}
