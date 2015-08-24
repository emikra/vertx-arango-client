package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class RemoveDocumentOptions {

    public String documentHandle;
    public String rev;
    public DocumentRevisionPolicy policy;
    public Boolean waitForSync;
    public String ifMatch;

    public RemoveDocumentOptions() {

    }

    public RemoveDocumentOptions(RemoveDocumentOptions options) {

    }

    public RemoveDocumentOptions(JsonObject json) {

    }

    public JsonObject toJson() {
        return null;
    }
}
