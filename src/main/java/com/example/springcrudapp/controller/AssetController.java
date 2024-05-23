package com.example.springcrudapp.controller;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/asset")
@AllArgsConstructor
public class AssetController {
    private final AssetService assetService;
    @GetMapping("/getAll")
    public Iterable<Asset> getAll() {
        return assetService.getAll();
    }

    @GetMapping("/getAllForCompany")
    public Iterable<Asset> getAll(@RequestParam UUID companyId) {
        return assetService.getAllById(companyId);
    }
}
