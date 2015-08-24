package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class RemoveDocumentResponse extends DocumentResponse {

    public RemoveDocumentResponse() {

    }

    public RemoveDocumentResponse(RemoveDocumentResponse response) {

    }

    public RemoveDocumentResponse(JsonObject json) {
        super(json);
    }

    public JsonObject toJson() {
        return null;
    }
}
