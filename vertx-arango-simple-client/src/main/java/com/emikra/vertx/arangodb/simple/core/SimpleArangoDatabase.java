package com.emikra.vertx.arangodb.simple.core;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionResponse;
import com.emikra.vertx.arangodb.http.collection.data.DropCollectionResponse;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import sun.java2d.pipe.SpanShapeRenderer;

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

    public Future<CreateCollectionResponse> createCollection(String name) {
        Future<CreateCollectionResponse> f = Future.future();
        createCollection(name, SimpleArango.futureHandler(f));
        return f;
    }

    public void dropCollection(String name, Handler<AsyncResult<DropCollectionResponse>> resultHandler) {
        arango.collection(res -> res.result().drop(name, SimpleArango.wrapHandler(resultHandler)));
    }

    public Future<DropCollectionResponse> dropCollection(String name) {
        Future<DropCollectionResponse> f = Future.future();
        dropCollection(name, SimpleArango.futureHandler(f));
        return f;
    }

    public SimpleArangoCollection coll(String collection) {
        return new SimpleArangoCollection(arango, collection);
    }
}
