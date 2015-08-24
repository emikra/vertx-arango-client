package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class SimpleQueryOptions {

    /**
     * Maximum number of results to be transferred in one batch from server
     */
    public Integer batchSize;

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("batchSize", this.batchSize);
        return json;
    }
}
