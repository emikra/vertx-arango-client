package com.emikra.vertx.arangodb.http.document.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetHeaderOptions {

    public String documentHandle;
    public String rev;
    public String ifNoneMatch;
    public String ifMatch;


    public GetHeaderOptions() {

    }

    public GetHeaderOptions(GetHeaderOptions options) {

    }

    public GetHeaderOptions(JsonObject json) {

    }

    public JsonObject toJson() {
        return null;
    }

}
