package com.emikra.vertx.arangodb.http.index;

import com.emikra.vertx.arangodb.http.index.data.*;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

@VertxGen
public interface ArangoIndexResource {

    void create(String collectionName, CreateIndexOptions options, Handler<AsyncResult<CreateIndexResponse>> handler);

    void get(String indexHandle, Handler<AsyncResult<GetIndexResponse>> handler);

    void getAll(String collectionName, Handler<AsyncResult<GetAllIndexesResponse>> handler);

    void remove(String indexHandle, Handler<AsyncResult<RemoveIndexResponse>> handler);

}
