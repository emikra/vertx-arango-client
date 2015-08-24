package com.emikra.vertx.arangodb.http;

import com.emikra.vertx.arangodb.http.collection.ArangoCollectionResource;
import com.emikra.vertx.arangodb.http.database.ArangoDatabaseResource;
import com.emikra.vertx.arangodb.http.document.ArangoDocumentResource;
import com.emikra.vertx.arangodb.http.impl.ArangoHttpClientImpl;
import com.emikra.vertx.arangodb.http.index.ArangoIndexResource;
import com.emikra.vertx.arangodb.http.query.simple.ArangoSimpleQueryResource;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

@VertxGen
public interface ArangoHttpClient {

    static ArangoHttpClient create(Vertx vertx, ArangoHttpClientOptions options) {
        return new ArangoHttpClientImpl(vertx, options);
    }

    void setHost(String host);

    void setPort(int port);

    void setCredentials(String username, String password);

    void setDatabase(String databaseName);

    void collection(Handler<AsyncResult<ArangoCollectionResource>> handler);

    void database(Handler<AsyncResult<ArangoDatabaseResource>> handler);

    void document(Handler<AsyncResult<ArangoDocumentResource>> handler);

    void index(Handler<AsyncResult<ArangoIndexResource>> handler);

    @GenIgnore
    void simpleQuery(Handler<AsyncResult<ArangoSimpleQueryResource>> handler);
}
