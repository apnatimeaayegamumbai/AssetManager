package com.apnatimeaayega.assetmanager.service;

import com.apnatimeaayeaga.assetmanager.jooq.generated.assetmanager.tables.pojos.Asset;
import com.apnatimeaayega.assetmanager.dao.AssetDAO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AssetService {

    private final Map<String, Asset> assetMap;
    private final AssetDAO assetDAO;

    public AssetService(AssetDAO assetDAO) {
        this.assetMap = new HashMap<>();
        this.assetDAO = assetDAO;
    }

    public Asset getAsset(String id) {
//        return Optional.ofNullable(assetMap.get(id))
//            .orElseThrow(() -> new RuntimeException("Asset not found: " + id));
        return assetDAO.fetchAsset(id);
    }

    public void addAsset(Asset asset) {
        //assetMap.put(asset.getId(), asset);
        assetDAO.storeAsset(asset);
    }
}
