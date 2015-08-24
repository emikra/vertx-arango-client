package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class FirstOptions {

    /**
     * Name of the collection to query
     */
    public String collection;

    /**
     * Number of documents to return at most (optional, default=1)
     */
    public Integer count;

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("collection", this.collection);
        json.put("count", this.count);
        return json;
    }

}
