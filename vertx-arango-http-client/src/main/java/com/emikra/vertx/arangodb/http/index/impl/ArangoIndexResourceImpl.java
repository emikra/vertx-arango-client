package com.emikra.vertx.arangodb.http.index.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.index.ArangoIndexResource;
import com.emikra.vertx.arangodb.http.index.data.*;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class ArangoIndexResourceImpl implements ArangoIndexResource {

    private ArangoHttpClientConnection conn;

    public ArangoIndexResourceImpl(ArangoHttpClientConnection connection) {
        this.conn = connection;
    }

    @Override
    public void create(String collectionName, CreateIndexOptions options, Handler<AsyncResult<CreateIndexResponse>> handler) {

        conn.client()
                .post("/_api/index", options.toJson())
                .param("collection", collectionName)
                .handler(response -> handler.handle(Future.succeededFuture(new CreateIndexResponse(response.toJson()))))
                .end();

    }

    @Override
    public void get(String indexHandle, Handler<AsyncResult<GetIndexResponse>> handler) {

        conn.client()
                .get("/_api/index/:indexHandle")
                .param("indexHandle", indexHandle)
                .handler(response -> handler.handle(Future.succeededFuture(new GetIndexResponse(response.toJson()))))
                .end();
    }

    @Override
    public void getAll(String collectionName, Handler<AsyncResult<GetAllIndexesResponse>> handler) {

        conn.client()
                .get("/_api/index")
                .handler(response -> handler.handle(Future.succeededFuture(new GetAllIndexesResponse(response.toJson()))))
                .end();
    }

    @Override
    public void remove(String indexHandle, Handler<AsyncResult<RemoveIndexResponse>> handler) {

        conn.client()
                .delete("/_api/index/:indexHandle")
                .param("indexHandle", indexHandle)
                .handler(response -> handler.handle(Future.succeededFuture(new RemoveIndexResponse(response.toJson()))))
                .end();

    }
}
