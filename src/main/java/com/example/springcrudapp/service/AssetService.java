package com.example.springcrudapp.service;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.repository.AssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;

    public Iterable<Asset> getAll() {
        return assetRepository.findAll();
    }

    public Iterable<Asset> getAllById(UUID companyId) {
        return assetRepository.findAllByCompanyId(companyId);
    }
}
