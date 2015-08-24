package com.emikra.vertx.arangodb.http.client.impl;


import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.client.ArangoCollection;
import com.emikra.vertx.arangodb.http.client.ArangoDatabase;
import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionOptions;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.function.Consumer;

public class ArangoDatabaseImpl implements ArangoDatabase {

    private ArangoHttpClient client;

    public ArangoDatabaseImpl(ArangoHttpClient client) {
        this.client = client;
    }

    @Override
    public void createCollection(CreateCollectionOptions options, Handler<AsyncResult<ArangoCollection>> handler) {

        this.client.collection(onSuccess(service -> {
            service.create(options, onSuccess(response -> {
                handler.handle(Future.succeededFuture(new ArangoCollectionImpl(client, response.getName())));
            }));
        }));
    }

    @Override
    public void createEdgeCollection(JsonObject properties, Handler<AsyncResult<ArangoCollection>> handler) {

    }

    @Override
    public void collection(String collectionName, Boolean autoCreate, Handler<AsyncResult<ArangoCollection>> handler) {

    }

    @Override
    public void edgeCollection(String collectionName, Boolean autoCreate, Handler<AsyncResult<ArangoCollection>> handler) {

    }

    @Override
    public void collections(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void allCollections(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void dropCollection(String collectionName, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void truncate(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void truncateAll(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void createDatabase(String databaseName, JsonArray users, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void database(String databaseName, Boolean autoCreate, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void databases(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void dropDatabase(String databaseName, Handler<AsyncResult<JsonObject>> handler) {

    }

    public <T> Handler<AsyncResult<T>> onSuccess(Consumer<T> consumer) {
        return onSuccess(consumer, null);
    }

    public <T> Handler<AsyncResult<T>> onSuccess(Consumer<T> consumer, Consumer<Throwable> errorConsumer) {
        return result -> {
            if (result.succeeded()) {
                consumer.accept(result.result());
            } else if (errorConsumer != null) {
                errorConsumer.accept(result.cause());
            }
        };
    }
}
