package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class PatchDocumentResponse extends DocumentResponse {

    public PatchDocumentResponse() {

    }

    public PatchDocumentResponse(PatchDocumentResponse response) {

    }

    public PatchDocumentResponse(JsonObject json) {
        super(json);
    }

    public JsonObject toJson() {
        return null;
    }
}
