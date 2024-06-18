package com.example.springcrudapp;

import com.example.springcrudapp.model.Asset;
import com.example.springcrudapp.repository.AssetRepository;
import com.example.springcrudapp.service.AssetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssetServiceTest {
    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetService assetService;

    @Test
    public void testGetAllAssets() {
        final int pageNumber = 0;
        final int pageSize = 2;

        Asset asset = new Asset();
        asset.setName("Asset 1");
        List<Asset> mockItems = List.of(asset);
        when(assetRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by("name")))).thenReturn(mockItems);

        List<Asset> items = assetService.getAll(pageNumber, pageSize);
        assertEquals(1, items.size());
        assertEquals("Asset 1", items.get(0).getName());
    }
}
