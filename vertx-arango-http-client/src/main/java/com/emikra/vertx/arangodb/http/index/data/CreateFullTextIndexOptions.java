package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateFullTextIndexOptions extends CreateIndexOptions {

    public final String FIELD_FIELDS = "fields";
    public final String FIELD_MIN_LEGNTH = "minLength";

    public CreateFullTextIndexOptions() {
        this(new JsonObject());
    }

    public CreateFullTextIndexOptions(CreateFullTextIndexOptions options) {
        this(options.toJson());
    }

    public CreateFullTextIndexOptions(JsonObject json) {
        super(json);
        this.setType("fulltext");
    }

    public CreateFullTextIndexOptions addField(String field) {
        if (!this.getJson().containsKey(FIELD_FIELDS)) {
            this.getJson().put(FIELD_FIELDS, new JsonArray());
        }

        this.getJson().getJsonArray(FIELD_FIELDS).add(field);
        return this;
    }

    public CreateFullTextIndexOptions setMinLength(Integer minLength) {
        this.getJson().put(FIELD_MIN_LEGNTH, minLength);
        return this;
    }

    public Integer getMinLength() {
        return this.getJson().getInteger(FIELD_MIN_LEGNTH);
    }
}
