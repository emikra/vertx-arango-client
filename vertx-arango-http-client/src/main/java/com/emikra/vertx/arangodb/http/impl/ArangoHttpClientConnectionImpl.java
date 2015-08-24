package com.emikra.vertx.arangodb.http.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.ArangoHttpClientOptions;
import com.emikra.vertx.request.RequestFactory;
import com.emikra.vertx.request.plugins.impl.ParameterizedUrlPlugin;
import com.emikra.vertx.request.plugins.impl.PrefixUrlPlugin;
import io.vertx.core.Vertx;

public class ArangoHttpClientConnectionImpl implements ArangoHttpClientConnection {

    private Vertx vertx;
    private RequestFactory client;

    public ArangoHttpClientConnectionImpl(Vertx vertx, ArangoHttpClientOptions options) {
        this.vertx = vertx;
        configure(options);
    }

    private void configure(ArangoHttpClientOptions options) {
        if (options.getDatabase() == null || options.getDatabase().trim().isEmpty()) {
            options.setDatabase("_system");
        }

        this.client = RequestFactory.create(vertx);
        this.client.defaultOptions()
                .host(options.getHost())
                .port(options.getPort())
                .auth(options.getUsername(), options.getPassword())
                .param("db", options.getDatabase())
                .use(new PrefixUrlPlugin("/_db/:db"))
                .use(new ParameterizedUrlPlugin());
    }

    public RequestFactory client() {
        return this.client;
    }
}
