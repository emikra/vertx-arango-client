package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import com.emikra.vertx.arangodb.http.data.Document;
import io.vertx.core.json.JsonObject;

public class FirstExampleResponse extends ArangoResponse {

    public FirstExampleResponse(JsonObject json) {
        super(json);
    }

    public Document getDocument() {
        return new Document(this.body.getJsonObject("document"));
    }
}
