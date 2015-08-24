package com.emikra.vertx.arangodb.simple.indexes.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.index.data.GeoSpatialIndexResponse;
import com.emikra.vertx.arangodb.simple.indexes.Index;
import com.emikra.vertx.arangodb.simple.indexes.IndexType;
import io.vertx.core.json.JsonObject;

public class GeoSpatialIndex extends Index<GeoSpatialIndexResponse, GeoSpatialIndex> {
    private boolean geoJsonOrder;

    public GeoSpatialIndex(ArangoHttpClient client, String collection) {
        super(client, collection, IndexType.Geo);
    }

    public Index useGeoJsonOrder() {
        this.geoJsonOrder = true;
        return this;
    }

    public boolean hasGeoJsonOrder() {
        return geoJsonOrder;
    }

    @Override
    protected GeoSpatialIndex getThis() {
        return this;
    }

    @Override
    protected void appendJson(JsonObject json) {
        json.put("geoJson", geoJsonOrder);
    }
}
