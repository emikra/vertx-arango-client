package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateGeoSpatialIndexOptions extends CreateIndexOptions {

    public final String FIELD_FIELDS = "fields";
    public final String FIELD_GEO_JSON = "geoJson";

    public CreateGeoSpatialIndexOptions() {
        this(new JsonObject());
    }

    public CreateGeoSpatialIndexOptions(CreateGeoSpatialIndexOptions options) {
        this(options.toJson());
    }

    public CreateGeoSpatialIndexOptions(JsonObject json) {
        super(json);
        this.setType("geo");
    }

    public CreateGeoSpatialIndexOptions addField(String field) {
        if (!this.getJson().containsKey(FIELD_FIELDS)) {
            this.getJson().put(FIELD_FIELDS, new JsonArray());
        }

        this.getJson().getJsonArray(FIELD_FIELDS).add(field);
        return this;
    }

    public CreateGeoSpatialIndexOptions setGeoJson(Boolean isGeoJson) {
        this.getJson().put(FIELD_GEO_JSON, isGeoJson);
        return this;
    }

    public Boolean getGeoJson() {
        return this.getJson().getBoolean(FIELD_GEO_JSON);
    }

}

