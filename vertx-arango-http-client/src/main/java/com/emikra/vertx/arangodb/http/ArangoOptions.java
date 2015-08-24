package com.emikra.vertx.arangodb.http;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ArangoOptions {

    private JsonObject json;

    public ArangoOptions() {
        this(new JsonObject());
    }

    public ArangoOptions(ArangoOptions options) {
        this(options.toJson());
    }

    public ArangoOptions(JsonObject json) {
        this.json = json;
    }

    public JsonObject toJson() {
        return json.copy();
    }

    protected JsonObject getJson() {
        return json;
    }
}
