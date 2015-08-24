package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetDocumentOptions {

    public String documentHandle;
    public String ifNoneMatch;
    public String ifMatch;

    public GetDocumentOptions() {

    }

    public GetDocumentOptions(GetDocumentOptions options) {

    }

    public GetDocumentOptions(JsonObject json) {

    }

    public JsonObject toJson() {
        return null;
    }
}
