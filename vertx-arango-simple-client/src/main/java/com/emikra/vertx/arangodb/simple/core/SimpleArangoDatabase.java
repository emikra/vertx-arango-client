package com.emikra.vertx.arangodb.simple.core;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionResponse;
import com.emikra.vertx.arangodb.http.collection.data.DropCollectionResponse;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class SimpleArangoDatabase {

    private ArangoHttpClient arango;
    private String dbName;

    SimpleArangoDatabase(ArangoHttpClient arango, String dbName) {
        this.arango = arango;
        this.dbName = dbName;
    }

    public String getName() {
        return dbName;
    }

    public void createCollection(String name, Handler<AsyncResult<CreateCollectionResponse>> resultHandler) {
        arango.collection(res -> res.result().create(name, SimpleArango.wrapHandler(resultHandler)));
    }

    public Future<CreateCollectionResponse> createCollectionFuture(String name) {
        Future<CreateCollectionResponse> f = Future.future();

        createCollection(name, res -> {
            if(res.succeeded()) {
                f.complete(res.result());
            } else {
                f.fail(res.cause());
            }
        });

        return f;
    }

    public void dropCollection(String name, Handler<AsyncResult<DropCollectionResponse>> resultHandler) {
        arango.collection(res -> res.result().drop(name, SimpleArango.wrapHandler(resultHandler)));
    }

    public SimpleArangoCollection coll(String collection) {
        return new SimpleArangoCollection(arango, collection);
    }
}
