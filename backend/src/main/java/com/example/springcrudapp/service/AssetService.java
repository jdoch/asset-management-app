package com.example.springcrudapp.service;

import com.example.springcrudapp.exception.AssetNotFound;
import com.example.springcrudapp.exception.CompanyNotFound;
import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.model.Company;
import com.example.springcrudapp.model.DTO.AssetDTO;
import com.example.springcrudapp.repository.AssetRepository;
import com.example.springcrudapp.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AssetService {

    private final AssetRepository assetRepository;
    private final CompanyRepository companyRepository;

    public List<Asset> getAll(int pageNumber, int pageSize) {
        return assetRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("name")));
    }

    public List<Asset> getAllByCompanyId(UUID companyId, int pageNumber, int pageSize) {
        return assetRepository.findAllByCompanyId(companyId, PageRequest.of(pageNumber, pageSize,
                Sort.by("name")));
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
