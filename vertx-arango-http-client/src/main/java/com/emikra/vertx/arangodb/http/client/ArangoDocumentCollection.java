package com.emikra.vertx.arangodb.http.client;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public interface ArangoDocumentCollection extends ArangoCollection {

    void document(String documentHandle, Handler<AsyncResult<JsonObject>> handler);

    void save(JsonObject document, Handler<AsyncResult<JsonObject>> handler);

}
