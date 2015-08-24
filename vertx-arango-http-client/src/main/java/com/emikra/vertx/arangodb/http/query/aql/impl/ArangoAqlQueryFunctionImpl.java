package com.emikra.vertx.arangodb.http.query.aql.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.query.aql.ArangoAqlQueryFunctionResource;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public class ArangoAqlQueryFunctionImpl implements ArangoAqlQueryFunctionResource {

    private ArangoHttpClientConnection conn;

    public ArangoAqlQueryFunctionImpl(ArangoHttpClientConnection connection) {
        this.conn = connection;
    }

    @Override
    public void create(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .post("/_api/aqlfunction", options)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void remove(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .delete("/_api/aqlfunction/:name", options)
                .param("name", "")
                .handler(response -> Future.succeededFuture(response))
                .end();

    }

    @Override
    public void getAll(String namespace, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .get("/_api/aqlfunction")
                .param("namespace", namespace)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }
}
