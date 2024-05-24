package com.example.springcrudapp.service;

import com.example.springcrudapp.exception.AssetNotFound;
import com.example.springcrudapp.exception.CompanyNotFound;
import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.model.Company;
import com.example.springcrudapp.model.DTO.AssetDTO;
import com.example.springcrudapp.repository.AssetRepository;
import com.example.springcrudapp.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;
    private final CompanyRepository companyRepository;

    public Iterable<Asset> getAll() {
        return assetRepository.findAll();
    }

    public Iterable<Asset> getAllByCompanyId(UUID companyId) {
        return assetRepository.findAllByCompanyId(companyId);
    }

    @Transactional
    public Asset addAssetToCompany(UUID companyId, AssetDTO assetDTO) {
        Company company = companyRepository.findById(companyId).orElseThrow(CompanyNotFound::new);
        Asset asset = new Asset(assetDTO);
        company.addAsset(asset);
        return asset;
    }

    @Transactional
    public void remove(UUID id) {
        if (!assetRepository.existsById(id)) {
            throw new AssetNotFound();
        }
        assetRepository.deleteById(id);
    }
}
