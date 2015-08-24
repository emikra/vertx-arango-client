package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

@DataObject
public class FullTextIndexResponse extends GetIndexResponse {

    public final String FIELD_FIELDS = "fields";
    public final String FIELD_UNIQUE = "unique";
    public final String FIELD_SPARSE = "sparse";
    public final String FIELD_MIN_LEGNTH = "minLength";

    public FullTextIndexResponse() {
        this(new JsonObject());
    }

    public FullTextIndexResponse(FullTextIndexResponse response) {
        this(response.toJson());
    }

    public FullTextIndexResponse(JsonObject json) {
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

    public Integer getMinLength() {
        return this.body.getInteger(FIELD_MIN_LEGNTH);
    }

}
