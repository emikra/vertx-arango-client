package com.emikra.vertx.arangodb.http.index.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetAllIndexesResponse extends ArangoResponse {

    public GetAllIndexesResponse() {
        this(new JsonObject());
    }

    public GetAllIndexesResponse(GetAllIndexesResponse response) {
        this(response.toJson());
    }

    public GetAllIndexesResponse(JsonObject json) {
        super(json);
    }
}
