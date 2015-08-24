package com.emikra.vertx.arangodb.http.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.ArangoHttpClientOptions;
import com.emikra.vertx.arangodb.http.collection.ArangoCollectionResource;
import com.emikra.vertx.arangodb.http.collection.impl.ArangoCollectionResourceImpl;
import com.emikra.vertx.arangodb.http.database.ArangoDatabaseResource;
import com.emikra.vertx.arangodb.http.database.impl.ArangoDatabaseResourceImpl;
import com.emikra.vertx.arangodb.http.document.ArangoDocumentResource;
import com.emikra.vertx.arangodb.http.document.impl.ArangoDocumentResourceImpl;
import com.emikra.vertx.arangodb.http.index.ArangoIndexResource;
import com.emikra.vertx.arangodb.http.index.impl.ArangoIndexResourceImpl;
import com.emikra.vertx.arangodb.http.query.simple.ArangoSimpleQueryResource;
import com.emikra.vertx.arangodb.http.query.simple.impl.ArangoSimpleQueryResourceImpl;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class ArangoHttpClientImpl implements ArangoHttpClient {

    private ArangoHttpClientConnection conn;

    public ArangoHttpClientImpl(Vertx vertx, ArangoHttpClientOptions options) {
        this.conn = new ArangoHttpClientConnectionImpl(vertx, options);
    }

    @Override
    public void setHost(String host) {
        this.conn.client().defaultOptions().host(host);
    }

    @Override
    public void setPort(int port) {
        this.conn.client().defaultOptions().port(port);
    }

    @Override
    public void setCredentials(String username, String password) {
        this.conn.client().defaultOptions().auth(username, password);
    }

    @Override
    public void setDatabase(String databaseName) {
        this.conn.client().defaultOptions().param("db", databaseName);
    }

    @Override
    public void collection(Handler<AsyncResult<ArangoCollectionResource>> handler) {
        handler.handle(Future.succeededFuture(new ArangoCollectionResourceImpl(conn)));
    }

    @Override
    public void database(Handler<AsyncResult<ArangoDatabaseResource>> handler) {
        handler.handle(Future.succeededFuture(new ArangoDatabaseResourceImpl(conn)));
    }

    @Override
    public void document(Handler<AsyncResult<ArangoDocumentResource>> handler) {
        handler.handle(Future.succeededFuture(new ArangoDocumentResourceImpl(conn)));
    }

    @Override
    public void index(Handler<AsyncResult<ArangoIndexResource>> handler) {
        handler.handle(Future.succeededFuture(new ArangoIndexResourceImpl(conn)));
    }

    @Override
    public void simpleQuery(Handler<AsyncResult<ArangoSimpleQueryResource>> handler) {
        handler.handle(Future.succeededFuture(new ArangoSimpleQueryResourceImpl(conn)));
    }
}
