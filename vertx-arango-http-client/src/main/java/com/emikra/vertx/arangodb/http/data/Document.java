package com.emikra.vertx.arangodb.http.data;

import io.vertx.core.json.JsonObject;

public class Document extends JsonObject {

    public Document(JsonObject json) {
        super(json.getMap());
    }

    public String getId() {
        return this.getString("_id");
    }

    public String getRevision() {
        return this.getString("_rev");
    }

    public String getKey() {
        return this.getString("_key");
    }


}
