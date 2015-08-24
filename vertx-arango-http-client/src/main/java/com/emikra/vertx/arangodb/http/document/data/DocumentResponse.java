package com.emikra.vertx.arangodb.http.document.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class DocumentResponse extends ArangoResponse {

    public DocumentResponse() {

    }

    public DocumentResponse(DocumentResponse response) {

    }

    public DocumentResponse(JsonObject json) {
        super(json);
    }

    public String getId() {
        return this.body.getString("_id");
    }

    public String getRevision() {
        return this.body.getString("_rev");
    }

    public String getKey() {
        return this.body.getString("_key");
    }

    public String getEtag() {
        return this.headers.get("Etag");
    }

    public String getLocation() {
        return this.headers.get("Location");
    }

    public JsonObject toJson() {
        return null;
    }
}
