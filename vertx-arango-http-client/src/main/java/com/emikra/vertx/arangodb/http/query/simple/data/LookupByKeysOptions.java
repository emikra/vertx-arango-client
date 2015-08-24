package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class LookupByKeysOptions {

    /**
    * Name of the collection to query
    */
    public String collection;

    public JsonArray keys;

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("collection", this.collection);
        json.put("keys", this.keys);
        return json;
    }
}
