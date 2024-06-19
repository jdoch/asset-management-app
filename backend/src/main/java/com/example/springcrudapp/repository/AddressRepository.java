package com.example.springcrudapp.repository;

import com.example.springcrudapp.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID> {
}
