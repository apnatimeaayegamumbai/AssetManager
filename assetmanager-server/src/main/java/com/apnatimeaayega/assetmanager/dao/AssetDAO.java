package com.apnatimeaayega.assetmanager.dao;

import static com.apnatimeaayeaga.assetmanager.jooq.generated.assetmanager.tables.Asset.ASSET;

import com.apnatimeaayeaga.assetmanager.jooq.generated.assetmanager.tables.pojos.Asset;
import com.apnatimeaayega.assetmanager.utils.JooqUtils;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

@Component
public class AssetDAO {

    private final JooqUtils jooqUtils;

    public AssetDAO(JooqUtils jooqUtils) {
        this.jooqUtils = jooqUtils;
    }

    public void storeAsset(Asset asset) {
        DSLContext context = jooqUtils.getAtomicDSLContext();

        context.insertInto(ASSET,
            ASSET.ID, ASSET.NAME, ASSET.CITY, ASSET.STATE, ASSET.ZIP_CODE)
            .values(asset.getId(), asset.getName(), asset.getCity(), asset.getState(), asset.getZipCode())
            .execute();
    }

    public Asset fetchAsset(String id) {
        DSLContext context = jooqUtils.getAtomicDSLContext();

        return context.selectFrom(ASSET)
            .where(ASSET.ID.eq(id))
            .fetchOne()
            .into(Asset.class);
    }
}
