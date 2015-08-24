package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class RemoveByExampleOptions extends SimpleQueryExampleOptions {

    public Boolean waitForSnyc;

    public Integer limit;

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("waitForSync", this.waitForSnyc);
        json.put("limit", this.limit);
        json.mergeIn(super.toJson());
        return json;
    }
}
