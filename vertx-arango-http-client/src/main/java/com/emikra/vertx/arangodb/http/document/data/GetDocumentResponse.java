package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetDocumentResponse extends DocumentResponse {

    public GetDocumentResponse() {

    }

    public GetDocumentResponse(GetDocumentResponse response) {

    }

    public GetDocumentResponse(JsonObject json) {
        super(json);
    }

    public JsonObject toJson() {
        return null;
    }
}
