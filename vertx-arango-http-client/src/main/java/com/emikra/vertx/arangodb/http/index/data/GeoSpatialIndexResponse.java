package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

@DataObject
public class GeoSpatialIndexResponse extends GetIndexResponse {

    public final String FIELD_FIELDS = "fields";
    public final String FIELD_GEO_JSON = "geoJson";
    public final String FIELD_UNIQUE = "unique";
    public final String FIELD_IGNORE_NULL = "ignoreNull";
    public final String FIELD_SPARSE = "sparse";

    public GeoSpatialIndexResponse() {
        this(new JsonObject());
    }

    public GeoSpatialIndexResponse(GeoSpatialIndexResponse response) {
        this(response.toJson());
    }

    public GeoSpatialIndexResponse(JsonObject json) {
        super(json);
    }

    public List<String> getFields() {
        List<String> fields = new LinkedList<>();

        JsonArray jsonFields = this.body.getJsonArray(FIELD_FIELDS);
        for (int i = 0; i < jsonFields.size(); i++) {
            fields.add(jsonFields.getString(i));
        }

        return fields;
    }

    public Boolean getGeoJson() {
        return this.body.getBoolean(FIELD_GEO_JSON);
    }

    public Boolean getUnique() {
        return this.body.getBoolean(FIELD_UNIQUE);
    }

    public Boolean getIgnoreNull() {
        return this.body.getBoolean(FIELD_IGNORE_NULL);
    }

    public Boolean getSparse() {
        return this.body.getBoolean(FIELD_SPARSE);
    }



}
