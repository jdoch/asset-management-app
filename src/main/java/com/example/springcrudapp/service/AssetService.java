package com.example.springcrudapp.service;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.repository.AssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;

    public Iterable<Asset> getAll() {
        return assetRepository.findAll();
    }
}
