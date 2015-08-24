package com.emikra.vertx.arangodb.http.database.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.database.ArangoDatabaseResource;
import com.emikra.vertx.arangodb.http.database.data.*;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class ArangoDatabaseResourceImpl implements ArangoDatabaseResource {

    private ArangoHttpClientConnection conn;

    public ArangoDatabaseResourceImpl(ArangoHttpClientConnection connection) {
        this.conn = connection;
    }

    @Override
    public void getInfo(Handler<AsyncResult<GetDatabaseInfoResponse>> handler) {

        this.conn.client()
                .get("/_api/database/current")
                .handler(response -> handler.handle(Future.succeededFuture(new GetDatabaseInfoResponse(response.toJson()))))
                .end();

    }

    @Override
    public void getInfo(String databaseName, Handler<AsyncResult<GetDatabaseInfoResponse>> handler) {

        this.conn.client()
                .get("/_api/database/current")
                .param("db", databaseName)
                .handler(response -> handler.handle(Future.succeededFuture(new GetDatabaseInfoResponse(response.toJson()))))
                .end();
    }

    @Override
    public void create(String databaseName, Handler<AsyncResult<CreateDatabaseResponse>> handler) {

        CreateDatabaseOptions options = new CreateDatabaseOptions();
        options.name = databaseName;

        create(options, handler);
    }

    @Override
    public void create(CreateDatabaseOptions options, Handler<AsyncResult<CreateDatabaseResponse>> handler) {

        this.conn.client()
                .post("/_api/database", options.toJson())
                .param("db", "_system")
                .handler(response -> handler.handle(Future.succeededFuture(new CreateDatabaseResponse(response.toJson()))))
                .end();

    }

    @Override
    public void list(Handler<AsyncResult<ListDatabaseResponse>> handler) {

        this.conn.client()
                .get("/_api/database")
                .param("db", "_system")
                .handler(response -> {
                    handler.handle(Future.succeededFuture(new ListDatabaseResponse(response.toJson())));
                })
                .end();
    }

    @Override
    public void listAccessible(Handler<AsyncResult<ListDatabaseResponse>> handler) {

        this.conn.client()
                .get("/_api/database/user")
                .param("db", "_system")
                .handler(response -> {
                    handler.handle(Future.succeededFuture(new ListDatabaseResponse(response.toJson())));
                })
                .end();
    }

    @Override
    public void drop(String databaseName, Handler<AsyncResult<DropDatabaseResponse>> handler) {

        this.conn.client()
                .delete("/_api/database/:dbToDrop")
                .param("db", "_system")
                .param("dbToDrop", databaseName)
                .handler(response -> handler.handle(Future.succeededFuture(new DropDatabaseResponse(response.toJson()))))
                .end();

    }

}
