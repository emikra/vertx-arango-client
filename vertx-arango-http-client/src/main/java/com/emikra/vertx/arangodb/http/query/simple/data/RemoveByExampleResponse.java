package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.core.json.JsonObject;

public class RemoveByExampleResponse extends ArangoResponse {

    public RemoveByExampleResponse(JsonObject json) {
        super(json);
    }
}
