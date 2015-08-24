package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class AnyOptions extends SimpleQueryOptions {

    /**
     * The identifier or name of the collection to query
     */
    public String collection;

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("collection", collection);
        json.mergeIn(super.toJson());
        return json;
    }
}
