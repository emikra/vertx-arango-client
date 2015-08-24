package com.emikra.vertx.arangodb.http.collection;

import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionOptions;
import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionResponse;
import com.emikra.vertx.arangodb.http.collection.data.DropCollectionResponse;
import com.emikra.vertx.arangodb.http.collection.data.TruncateCollectionResponse;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

@VertxGen
public interface ArangoCollectionResource {

    void create(String collectionName, Handler<AsyncResult<CreateCollectionResponse>> handler);

    void create(CreateCollectionOptions options, Handler<AsyncResult<CreateCollectionResponse>> handler);

    void drop(String collectionName, Handler<AsyncResult<DropCollectionResponse>> handler);

    void truncate(String collectionName, Handler<AsyncResult<TruncateCollectionResponse>> handler);
}
