package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class RemoveByKeysOptions {

    /**
     * Name of the collection to query
     */
    public String collection;

    public JsonArray keys;

    public Boolean waitForSync;

    public RemoveByKeysOptions() {
        keys = new JsonArray();
    }

    public void addKey(String key) {
        keys.add(key);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("collection", this.collection);
        json.put("keys", this.keys);
        json.put("waitForSync", this.waitForSync);
        return json;
    }

}
