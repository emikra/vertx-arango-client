package com.emikra.vertx.arangodb.http.client.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.client.ArangoClient;
import com.emikra.vertx.arangodb.http.client.ArangoDatabase;
import com.emikra.vertx.arangodb.http.client.data.ArangoDatabaseOptions;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public class ArangoClientImpl implements ArangoClient {

    private ArangoHttpClient client;

    public ArangoClientImpl(ArangoHttpClient client) {
        this.client = client;
    }


    @Override
    public void database(ArangoDatabaseOptions options, Handler<AsyncResult<ArangoDatabase>> handler) {

    }
}
