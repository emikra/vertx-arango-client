package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ReplaceDocumentOptions {

    public JsonObject document;
    public String documentHandle;
    public Boolean waitForSync;
    public String rev;
    public DocumentRevisionPolicy policy;
    public String ifMatch;

    public ReplaceDocumentOptions() {

    }

    public ReplaceDocumentOptions(ReplaceDocumentOptions options) {

    }

    public ReplaceDocumentOptions(JsonObject json) {

    }

    public JsonObject toJson() {
        return null;
    }

}
