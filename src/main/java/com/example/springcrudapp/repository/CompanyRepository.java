package com.example.springcrudapp.repository;

import com.example.springcrudapp.model.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CompanyRepository extends CrudRepository<Company, UUID> {
}
