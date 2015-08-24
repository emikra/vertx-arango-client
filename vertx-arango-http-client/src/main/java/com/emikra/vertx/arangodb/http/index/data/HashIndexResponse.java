package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

@DataObject
public class HashIndexResponse extends GetIndexResponse {

    public final String FIELD_FIELDS = "fields";
    public final String FIELD_SELECTIVITY_ESTIMATE = "selectivityEstimate";
    public final String FIELD_UNIQUE = "unique";
    public final String FIELD_SPARSE = "sparse";

    public HashIndexResponse() {
        this(new JsonObject());
    }

    public HashIndexResponse(HashIndexResponse response) {
        this(response.toJson());
    }

    public HashIndexResponse(JsonObject json) {
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

    public Integer getSelectivityEstimate() {
        return this.body.getInteger(FIELD_SELECTIVITY_ESTIMATE);
    }

    public Boolean getUnique() {
        return this.body.getBoolean(FIELD_UNIQUE);
    }

    public Boolean getSparse() {
        return this.body.getBoolean(FIELD_SPARSE);
    }

}
