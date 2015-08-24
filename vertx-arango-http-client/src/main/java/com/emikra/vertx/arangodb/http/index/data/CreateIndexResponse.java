package com.emikra.vertx.arangodb.http.index.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateIndexResponse extends ArangoResponse {

    public final String FIELD_IS_NEWLY_CREATED = "isNewlyCreated";

    public CreateIndexResponse() {
        this(new JsonObject());
    }

    public CreateIndexResponse(CreateIndexResponse response) {
        this(response.toJson());
    }

    public CreateIndexResponse(JsonObject json) {
        super(json);
    }

    public Boolean isNewlyCreated() {
        return this.body.getBoolean(FIELD_IS_NEWLY_CREATED);
    }

    public CapConstraintResponse getAsCapConstraintResponse() {
        return new CapConstraintResponse(this.toJson());
    }

    public HashIndexResponse getAsHashIndexResponse() {
        return new HashIndexResponse(this.toJson());
    }

    public SkipListIndexResponse getAsSkipListIndexResponse() {
        return new SkipListIndexResponse(this.toJson());
    }

    public GeoSpatialIndexResponse getAsGeoSpatialIndexResponse() {
        return new GeoSpatialIndexResponse(this.toJson());
    }

    public FullTextIndexResponse getAsFullTextIndexResponse() {
        return new FullTextIndexResponse(this.toJson());
    }

}
