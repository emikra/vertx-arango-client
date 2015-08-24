package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateDocumentOptions {

    public String collection;
    public JsonObject document;
    public Boolean createCollection;
    public Boolean waitForSync;

    public CreateDocumentOptions() {

    }

    public CreateDocumentOptions(CreateDocumentOptions options) {

    }

    public CreateDocumentOptions(JsonObject json) {

    }

    public JsonObject toJson() {
        return null;
    }
}
