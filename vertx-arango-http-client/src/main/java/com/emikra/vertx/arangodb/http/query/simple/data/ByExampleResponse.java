package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class ByExampleResponse extends SimpleQueryCursorResponse {

    public ByExampleResponse(JsonObject json) {
        super(json);
    }
}
