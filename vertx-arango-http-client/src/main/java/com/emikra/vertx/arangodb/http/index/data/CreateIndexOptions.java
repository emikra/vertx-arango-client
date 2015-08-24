package com.emikra.vertx.arangodb.http.index.data;

import com.emikra.vertx.arangodb.http.ArangoOptions;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateIndexOptions extends ArangoOptions {

    private final String FIELD_TYPE = "type";

    public CreateIndexOptions() {
        this(new JsonObject());
    }

    public CreateIndexOptions(CreateIndexOptions options) {
        this(options.toJson());
    }

    public CreateIndexOptions(JsonObject json) {
        super(json);
    }

    public CreateIndexOptions(String type) {
        this.setType(type);
    }

    public CreateIndexOptions setType(String type) {
        this.getJson().put(FIELD_TYPE, type);
        return this;
    }

    public String getType() {
        return this.getJson().getString(FIELD_TYPE);
    }
}
