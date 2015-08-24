package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateDocumentResponse extends DocumentResponse {

    public CreateDocumentResponse() {

    }

    public CreateDocumentResponse(CreateDocumentResponse response) {

    }

    public CreateDocumentResponse(JsonObject json) {
        super(json);
    }

    public JsonObject toJson() {
        return null;
    }

}
