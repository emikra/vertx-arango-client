package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class PatchDocumentOptions {

    public JsonObject document;
    public String documentHandle;
    public Boolean keepNull;
    public Boolean mergeObjects;
    public Boolean waitForSync;
    public String rev;
    public DocumentRevisionPolicy policy;
    public String ifMatch;


    public PatchDocumentOptions() {

    }

    public PatchDocumentOptions(PatchDocumentOptions options) {

    }

    public PatchDocumentOptions(JsonObject json) {

    }

    public JsonObject toJson() {
        return null;
    }


}
