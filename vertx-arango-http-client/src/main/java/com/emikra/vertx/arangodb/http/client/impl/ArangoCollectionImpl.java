package com.emikra.vertx.arangodb.http.client.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.client.ArangoCollection;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public class ArangoCollectionImpl implements ArangoCollection {

    public ArangoCollectionImpl(ArangoHttpClient client, String collectionName) {

    }

    @Override
    public void properties(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void count(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void figures(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void revision(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void checksum(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void load(Boolean count, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void unload(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void setProperties(JsonObject properties, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void rename(String name, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void rotate(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void truncate(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void drop(Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void replace(String documentHandle, JsonObject document, JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void update(String documentHandle, JsonObject document, JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void remove(String documentHandle, JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

    }

    @Override
    public void all(String type, Handler<AsyncResult<JsonObject>> handler) {

    }
}
