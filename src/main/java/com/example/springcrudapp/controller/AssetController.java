package com.example.springcrudapp.controller;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.service.AssetService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asset")
public class AssetController {
    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PutMapping("/decrease")
    public Asset getAllWhere(@RequestParam String id) {
        return assetService.decreaseAmount(id);
    }
}
