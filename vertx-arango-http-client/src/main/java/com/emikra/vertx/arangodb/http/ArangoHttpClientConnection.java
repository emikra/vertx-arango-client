package com.emikra.vertx.arangodb.http;

import com.emikra.vertx.arangodb.http.impl.ArangoHttpClientConnectionImpl;
import com.emikra.vertx.request.RequestFactory;
import io.vertx.core.Vertx;

public interface ArangoHttpClientConnection {

    static ArangoHttpClientConnection create(Vertx vertx, ArangoHttpClientOptions options) {
        return new ArangoHttpClientConnectionImpl(vertx, options);
    }

    RequestFactory client();
}
