package com.emikra.vertx.arangodb.http.collection.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class DropCollectionResponse extends ArangoResponse {

    public DropCollectionResponse() {

    }

    public DropCollectionResponse(DropCollectionResponse response) {

    }

    public DropCollectionResponse(JsonObject json) {
        super(json);
    }

    public String getId() {
        return this.body.getString("id");
    }

}
