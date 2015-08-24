package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.core.json.JsonObject;

public class LastResponse extends ArangoResponse {

    public LastResponse(JsonObject json) {
        super(json);
    }
}
