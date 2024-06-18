package com.example.springcrudapp.repository;

import com.example.springcrudapp.model.Asset;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface AssetRepository extends CrudRepository<Asset, UUID> {
    List<Asset> findAll(Pageable pageable);
    List<Asset> findAllByCompanyId(UUID companyId, Pageable pageable);
}
