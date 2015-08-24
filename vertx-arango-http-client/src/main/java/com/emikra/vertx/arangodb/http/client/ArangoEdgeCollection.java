package com.emikra.vertx.arangodb.http.client;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public interface ArangoEdgeCollection extends ArangoCollection {

    void edge(String documentHandle, Handler<AsyncResult<JsonObject>> handler);

    void save(JsonObject document, String fromDocumentHandle, String toDocumentHandle, Handler<AsyncResult<JsonObject>> handler);

    void edges(String documentHandle, Handler<AsyncResult<JsonObject>> handler);

    void inEdges(String documentHandle, Handler<AsyncResult<JsonObject>> handler);

    void outEdges(String documentHandle, Handler<AsyncResult<JsonObject>> handler);

    void traversal(String startVerx, JsonObject options, Handler<AsyncResult<JsonObject>> handler);

}
