package com.emikra.vertx.arangodb.http.query.aql;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public interface ArangoAqlQueryFunctionResource {

    void create(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void remove(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void getAll(String namespace, Handler<AsyncResult<JsonObject>> handler);

}
