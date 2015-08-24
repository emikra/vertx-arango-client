package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class SimpleQueryExampleOptions extends SimpleQueryOptions {

    /**
     * The name of the collection to query.
     */
    public String collection;

    /**
     * The example document
     */
    public JsonObject example;

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("collection", this.collection);
        json.put("example", this.example);
        json.mergeIn(super.toJson());
        return json;
    }

}
