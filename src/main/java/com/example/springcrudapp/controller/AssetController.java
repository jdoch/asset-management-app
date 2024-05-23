package com.example.springcrudapp.controller;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.service.AssetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asset")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping("/getAll")
    public Iterable<Asset> getAll() {
        return assetService.getAll();
    }
}
