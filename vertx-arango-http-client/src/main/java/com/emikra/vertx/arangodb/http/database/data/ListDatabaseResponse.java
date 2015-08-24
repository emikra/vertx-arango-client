package com.emikra.vertx.arangodb.http.database.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ListDatabaseResponse extends ArangoResponse {

    public ListDatabaseResponse() {

    }

    public ListDatabaseResponse(ListDatabaseResponse response) {

    }

    public ListDatabaseResponse(JsonObject json) {
        super(json);
    }

}
