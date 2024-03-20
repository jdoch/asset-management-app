package com.example.springcrudapp.service;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.repository.AssetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    //@Transactional
    @Transactional//(isolation = Isolation.READ_COMMITTED)
    public Asset decreaseAmount(String id) {
        var asset = assetRepository.findById(UUID.fromString(id)).orElseThrow();

        if (asset.getValue() > 0) {
            asset.setValue(asset.getValue() - 1);
            System.out.println("Will be updated");
        } else {
            System.out.println("Will not be updated");
        }
        /*try {
            Thread.sleep(30 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return asset;
    }
}
