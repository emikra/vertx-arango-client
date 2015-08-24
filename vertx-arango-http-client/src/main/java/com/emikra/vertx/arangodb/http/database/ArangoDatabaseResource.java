package com.emikra.vertx.arangodb.http.database;

import com.emikra.vertx.arangodb.http.database.data.*;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

@VertxGen
public interface ArangoDatabaseResource {

    void getInfo(Handler<AsyncResult<GetDatabaseInfoResponse>> handler);

    void getInfo(String databaseName, Handler<AsyncResult<GetDatabaseInfoResponse>> handler);

    void create(String databaseName, Handler<AsyncResult<CreateDatabaseResponse>> handler);

    void create(CreateDatabaseOptions options, Handler<AsyncResult<CreateDatabaseResponse>> handler);

    void list(Handler<AsyncResult<ListDatabaseResponse>> handler);

    void listAccessible(Handler<AsyncResult<ListDatabaseResponse>> handler);

    void drop(String databaseName, Handler<AsyncResult<DropDatabaseResponse>> handler);

}
