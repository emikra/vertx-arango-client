package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ReplaceDocumentResponse extends DocumentResponse {

    public ReplaceDocumentResponse() {

    }

    public ReplaceDocumentResponse(ReplaceDocumentResponse response) {

    }

    public ReplaceDocumentResponse(JsonObject json) {
        super(json);
    }

    public JsonObject toJson() {
        return null;
    }

}
