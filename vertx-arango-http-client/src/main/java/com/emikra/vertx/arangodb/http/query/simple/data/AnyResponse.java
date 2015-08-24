package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.data.Document;
import io.vertx.core.json.JsonObject;

public class AnyResponse extends SimpleQueryCursorResponse {

    public AnyResponse(JsonObject json) {
        super(json);
    }

    public JsonObject getJsonDocument() {
        return this.body.getJsonObject("document");
    }

    public Document getDocument() {
        return new Document(getJsonDocument());
    }

}
