package com.emikra.vertx.arangodb.simple.core;

import com.emikra.vertx.arangodb.http.ArangoError;
import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.ArangoHttpClientOptions;
import com.emikra.vertx.arangodb.http.database.data.CreateDatabaseOptions;
import com.emikra.vertx.arangodb.http.database.data.CreateDatabaseResponse;
import com.emikra.vertx.arangodb.http.database.data.DropDatabaseResponse;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

import java.util.Objects;

/**
 * A wrapper around {@link ArangoHttpClient} that provides a more fluent, simpler API
 * for use in verticles.
 */
public class SimpleArangoClient {

    private Vertx vertx;
    private ArangoHttpClientOptions options;
    private ArangoHttpClient arango;

    public SimpleArangoClient(Vertx vertx, ArangoHttpClientOptions options) {
        this.vertx = vertx;
        this.options = new ArangoHttpClientOptions(options);
        this.arango = ArangoHttpClient.create(vertx, options);
    }

    public void createDatabase(String dbName, Handler<AsyncResult<CreateDatabaseResponse>> resultHandler) {
        arango.database(res -> res.result().create(dbName, SimpleArango.wrapHandler(resultHandler)));
    }

    public Future<CreateDatabaseResponse> createDatabase(String dbName) {
        Future<CreateDatabaseResponse> f = Future.future();
        createDatabase(dbName, SimpleArango.futureHandler(f));
        return f;
    }

    public void dropDatabase(String dbName, Handler<AsyncResult<DropDatabaseResponse>> resultHandler) {
        arango.database(res -> res.result().drop(dbName, SimpleArango.wrapHandler(resultHandler)));
    }

    public Future<DropDatabaseResponse> dropDatabase(String dbName) {
        Future<DropDatabaseResponse> f = Future.future();
        dropDatabase(dbName, SimpleArango.futureHandler(f));
        return f;
    }

    public void databaseExists(String dbName, Handler<AsyncResult<Boolean>> resultHandler) {
        arango.database(db -> db.result().getInfo(dbName, SimpleArango.wrapHandler(info -> {
            if(info.succeeded()) {
                resultHandler.handle(Future.succeededFuture(Boolean.TRUE));
            } else if(info.cause() instanceof NotFoundError) {
                resultHandler.handle(Future.succeededFuture(Boolean.FALSE));
            } else {
                resultHandler.handle(Future.failedFuture(info.cause()));
            }
        })));
    }

    public Future<Boolean> databaseExists(String dbName) {
        Future<Boolean> f = Future.future();
        databaseExists(dbName, SimpleArango.futureHandler(f));
        return f;
    }

    public SimpleArangoDatabase db() {
        return db(options.getDatabase());
    }

    public SimpleArangoDatabase db(String dbName) {
        ArangoHttpClientOptions newOpts = new ArangoHttpClientOptions(options).setDatabase(dbName);
        return new SimpleArangoDatabase(ArangoHttpClient.create(vertx, newOpts), dbName);
    }
}
