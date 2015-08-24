package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.core.json.JsonObject;

public class RemoveByKeysResponse extends ArangoResponse {

    public RemoveByKeysResponse(JsonObject json) {
        super(json);
    }

    public Integer getIgnored() {
        return this.body.getInteger("ignored");
    }

    public Integer getRemoved() {
        return this.body.getInteger("removed");
    }
}
