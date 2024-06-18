package com.example.springcrudapp.repository;

import com.example.springcrudapp.model.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;
import java.util.UUID;

public interface CompanyRepository extends CrudRepository<Company, UUID> {
    Boolean existsAllByIdIn(List<UUID> ids);

    List<Company> findAll(Pageable pageable);
}
