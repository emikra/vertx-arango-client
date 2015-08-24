package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.core.json.JsonObject;

public class FirstResponse extends ArangoResponse {

    public FirstResponse(JsonObject json) {
        super(json);
    }
}
