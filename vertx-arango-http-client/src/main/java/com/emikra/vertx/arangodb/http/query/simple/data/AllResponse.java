package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class AllResponse extends SimpleQueryCursorResponse {

    public AllResponse(JsonObject json) {
        super(json);
    }

}
