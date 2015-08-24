package com.emikra.vertx.arangodb.http.document.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetAllDocumentsResponse extends ArangoResponse {

    public GetAllDocumentsResponse() {

    }

    public GetAllDocumentsResponse(GetAllDocumentsResponse response) {

    }

    public GetAllDocumentsResponse(JsonObject json) {
        super(json);
    }

    public JsonArray getDocuments() {
        return this.body.getJsonArray("documents");
    }

    public JsonObject toJson() {
        return null;
    }
}
