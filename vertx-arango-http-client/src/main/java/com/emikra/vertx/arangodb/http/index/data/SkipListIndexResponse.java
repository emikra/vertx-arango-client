package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

@DataObject
public class SkipListIndexResponse extends GetIndexResponse {

    public final String FIELD_FIELDS = "fields";
    public final String FIELD_UNIQUE = "unique";
    public final String FIELD_SPARSE = "sparse";

    public SkipListIndexResponse() {
        this(new JsonObject());
    }

    public SkipListIndexResponse(SkipListIndexResponse response) {
        this(response.toJson());
    }

    public SkipListIndexResponse(JsonObject json) {
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
    public Boolean getUnique() {
        return this.body.getBoolean(FIELD_UNIQUE);
    }

    public Boolean getSparse() {
        return this.body.getBoolean(FIELD_SPARSE);
    }

}
