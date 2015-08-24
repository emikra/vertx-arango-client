package com.emikra.vertx.arangodb.http.query.aql.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.query.aql.ArangoAqlQueryCursorResource;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public class ArangoAqlQueryCursorResourceImpl implements ArangoAqlQueryCursorResource {

    private ArangoHttpClientConnection conn;

    public ArangoAqlQueryCursorResourceImpl(ArangoHttpClientConnection connection) {
        this.conn = connection;
    }

    @Override
    public void query(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .post("/_api/cursor", options)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void next(String cursorId, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .put("/_api/cursor/:cursorId")
                .param("cursorId", cursorId)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }
}
