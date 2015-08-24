package com.emikra.vertx.arangodb.http.index.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class RemoveIndexResponse extends ArangoResponse {

    public RemoveIndexResponse() {
        this(new JsonObject());
    }

    public RemoveIndexResponse(RemoveIndexResponse response) {
        this(response.toJson());
    }

    public RemoveIndexResponse(JsonObject json) {
        super(json);
    }

    public String getId() {
        return this.body.getString("id");
    }
}
