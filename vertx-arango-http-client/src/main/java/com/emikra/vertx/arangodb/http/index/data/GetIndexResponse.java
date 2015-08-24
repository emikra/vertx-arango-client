package com.emikra.vertx.arangodb.http.index.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetIndexResponse extends ArangoResponse {

    public GetIndexResponse() {
        this(new JsonObject());
    }

    public GetIndexResponse(GetIndexResponse response) {
        this(response.toJson());
    }

    public GetIndexResponse(JsonObject json) {
        super(json);
    }

    public String getId() {
        return this.body.getString("id");
    }

    public String getType() {
        return this.body.getString("type");
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
