package com.emikra.vertx.arangodb.http.database.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateDatabaseResponse extends ArangoResponse {

    public CreateDatabaseResponse() {

    }

    public CreateDatabaseResponse(CreateDatabaseResponse response) {

    }

    public CreateDatabaseResponse(JsonObject json) {
        super(json);
    }

    public Boolean getResult() {
        return this.body.getBoolean("result");
    }
}
