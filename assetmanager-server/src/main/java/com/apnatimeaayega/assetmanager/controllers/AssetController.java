package com.apnatimeaayega.assetmanager.controllers;

import com.apnatimeaayeaga.assetmanager.jooq.generated.assetmanager.tables.pojos.Asset;
import com.apnatimeaayega.assetmanager.service.AssetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asset")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public String addAsset(@RequestBody Asset asset) {
        assetService.addAsset(asset);
        return "asset saved";
    }

    @GetMapping("/{id}")
    public Asset getAsset(@PathVariable("id") String id) {
        return assetService.getAsset(id);
    }
}
