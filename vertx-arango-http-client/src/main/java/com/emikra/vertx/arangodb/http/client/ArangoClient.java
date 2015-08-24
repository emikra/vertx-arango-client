package com.emikra.vertx.arangodb.http.client;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.client.data.ArangoDatabaseOptions;
import com.emikra.vertx.arangodb.http.client.impl.ArangoClientImpl;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public interface ArangoClient {

    static ArangoClient create(ArangoHttpClient client) {
        return new ArangoClientImpl(client);
    }

    void database(ArangoDatabaseOptions options, Handler<AsyncResult<ArangoDatabase>> handler);
}
