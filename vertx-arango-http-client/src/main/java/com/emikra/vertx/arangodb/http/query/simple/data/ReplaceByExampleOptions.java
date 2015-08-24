package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class ReplaceByExampleOptions extends SimpleQueryExampleOptions {

    public JsonObject newValue;

    public Boolean waitForSync;

    public Integer limit;

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("newValue", this.newValue);
        json.put("waitForSync", this.waitForSync);
        json.put("limit", this.limit);
        json.mergeIn(super.toJson());
        return json;
    }

}
