package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateHashIndexOptions extends CreateIndexOptions {

    public final String FIELD_FIELDS = "fields";
    public final String FIELD_UNIQUE = "unique";
    public final String FIELD_SPARSE = "sparse";

    public CreateHashIndexOptions() {
        this(new JsonObject());
    }

    public CreateHashIndexOptions(CreateHashIndexOptions options) {
        this(options.toJson());
    }

    public CreateHashIndexOptions(JsonObject json) {
        super(json);
        this.setType("hash");
    }

    public CreateHashIndexOptions setUnique(Boolean isUnique) {
        this.getJson().put(FIELD_UNIQUE, isUnique);
        return this;
    }

    public Boolean getUnique() {
        return this.getJson().getBoolean(FIELD_UNIQUE);
    }

    public CreateHashIndexOptions setSparse(Boolean isSparse) {
        this.getJson().put(FIELD_SPARSE, isSparse);
        return this;
    }

    public Boolean getSparse() {
        return this.getJson().getBoolean(FIELD_SPARSE);
    }

    public CreateHashIndexOptions addField(String field) {
        if (!this.getJson().containsKey(FIELD_FIELDS)) {
            this.getJson().put(FIELD_FIELDS, new JsonArray());
        }

        this.getJson().getJsonArray(FIELD_FIELDS).add(field);
        return this;
    }

}
