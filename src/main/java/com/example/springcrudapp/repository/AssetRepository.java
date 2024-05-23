package com.example.springcrudapp.repository;

import com.example.springcrudapp.model.Asset;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AssetRepository extends CrudRepository<Asset, UUID> {
}
