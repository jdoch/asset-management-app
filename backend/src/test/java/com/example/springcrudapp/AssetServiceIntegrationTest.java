package com.example.springcrudapp;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.repository.AssetRepository;
import com.example.springcrudapp.service.AssetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class AssetServiceIntegrationTest {
    @Autowired
    private AssetService assetService;

    @Autowired
    private AssetRepository assetRepository;

    @Test
    public void testGetAllAssets() {
        Asset asset = new Asset();
        asset.setName("Asset 1");
        assetRepository.save(asset);

        List<Asset> items = assetService.getAll(0, 2);
        assertEquals(1, items.size());
        assertEquals("Asset 1", items.get(0).getName());
    }
}
