package com.emikra.vertx.arangodb.http.database.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class DropDatabaseResponse extends ArangoResponse {

    public DropDatabaseResponse() {

    }

    public DropDatabaseResponse(DropDatabaseResponse response) {

    }

    public DropDatabaseResponse(JsonObject json) {
        super(json);
    }


}
