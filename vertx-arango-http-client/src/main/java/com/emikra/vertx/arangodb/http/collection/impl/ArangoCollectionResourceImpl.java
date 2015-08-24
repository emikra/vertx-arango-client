package com.emikra.vertx.arangodb.http.collection.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.collection.ArangoCollectionResource;
import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionOptions;
import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionResponse;
import com.emikra.vertx.arangodb.http.collection.data.DropCollectionResponse;
import com.emikra.vertx.arangodb.http.collection.data.TruncateCollectionResponse;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class ArangoCollectionResourceImpl implements ArangoCollectionResource {

    private ArangoHttpClientConnection conn;

    public ArangoCollectionResourceImpl(ArangoHttpClientConnection connection) {
        this.conn = connection;
    }

    @Override
    public void create(String collectionName, Handler<AsyncResult<CreateCollectionResponse>> handler) {

        CreateCollectionOptions options = new CreateCollectionOptions();
        options.name = collectionName;

        create(options, handler);
    }

    @Override
    public void create(CreateCollectionOptions options, Handler<AsyncResult<CreateCollectionResponse>> handler) {

        conn.client()
                .post("/_api/collection", options.toJson())
                .handler(response -> {
                    handler.handle(Future.succeededFuture(new CreateCollectionResponse(response.toJson())));
                })
                .end();
    }

    @Override
    public void drop(String collectionName, Handler<AsyncResult<DropCollectionResponse>> handler) {

        conn.client()
                .del("/_api/collection/:collectionName")
                .param("collectionName", collectionName)
                .handler(response -> handler.handle(Future.succeededFuture(new DropCollectionResponse(response.toJson()))))
                .end();
    }

    @Override
    public void truncate(String collectionName, Handler<AsyncResult<TruncateCollectionResponse>> handler) {

        conn.client()
                .put("/_api/collection/:collectionName/truncate")
                .param("collectionName", collectionName)
                .handler(response -> Future.succeededFuture(new TruncateCollectionResponse(response.toJson())))
                .end();

    }
}
