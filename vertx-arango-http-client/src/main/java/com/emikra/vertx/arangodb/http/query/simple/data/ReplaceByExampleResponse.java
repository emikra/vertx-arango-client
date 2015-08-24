package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.core.json.JsonObject;

public class ReplaceByExampleResponse extends ArangoResponse {

    public ReplaceByExampleResponse(JsonObject json) {
        super(json);
    }
}
