package com.example.springcrudapp.controller;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.model.DTO.AssetDTO;
import com.example.springcrudapp.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/asset")
@AllArgsConstructor
public class AssetController {
    private final AssetService assetService;
    @GetMapping("/getAll")
    public List<Asset> getAll(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return assetService.getAll(pageNumber, pageSize);
    }

    @GetMapping("/getAllForCompany")
    public List<Asset> getAll(@RequestParam UUID companyId, @RequestParam int pageNumber, @RequestParam int pageSize) {
        return assetService.getAllByCompanyId(companyId, pageNumber, pageSize);
    }

    @PostMapping("/addToCompany")
    public Asset getAll(@RequestParam UUID companyId,
                        @RequestBody AssetDTO assetDTO) {
        return assetService.addAssetToCompany(companyId, assetDTO);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam UUID id) {
        assetService.remove(id);
    }
}
