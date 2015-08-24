package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetHeaderResponse extends DocumentResponse {

    public GetHeaderResponse() {

    }

    public GetHeaderResponse(GetHeaderResponse response) {

    }

    public GetHeaderResponse(JsonObject json) {
        super(json);
    }

    public JsonObject toJson() {
        return null;
    }
}
