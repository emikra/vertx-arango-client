package com.emikra.vertx.arangodb.http.client;

import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionOptions;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public interface ArangoDatabase {

    void createCollection(CreateCollectionOptions options, Handler<AsyncResult<ArangoCollection>> handler);

    void createEdgeCollection(JsonObject properties, Handler<AsyncResult<ArangoCollection>> handler);

    void collection(String collectionName, Boolean autoCreate, Handler<AsyncResult<ArangoCollection>> handler);

    void edgeCollection(String collectionName, Boolean autoCreate, Handler<AsyncResult<ArangoCollection>> handler);

    void collections(Handler<AsyncResult<JsonObject>> handler);

    void allCollections(Handler<AsyncResult<JsonObject>> handler);

    void dropCollection(String collectionName, Handler<AsyncResult<JsonObject>> handler);

    void truncate(Handler<AsyncResult<JsonObject>> handler);

    void truncateAll(Handler<AsyncResult<JsonObject>> handler);

    // TODO: Manipulating graphs (https://github.com/arangodb/arangojs#manipulating-graphs)

    void createDatabase(String databaseName, JsonArray users, Handler<AsyncResult<JsonObject>> handler);

    void database(String databaseName, Boolean autoCreate, Handler<AsyncResult<JsonObject>> handler);

    void databases(Handler<AsyncResult<JsonObject>> handler);

    void dropDatabase(String databaseName, Handler<AsyncResult<JsonObject>> handler);

    // TODO: Transactions (https://github.com/arangodb/arangojs#transactions)

    // TODO: Queries (https://github.com/arangodb/arangojs#queries)

    // TODO: AQL functions (https://github.com/arangodb/arangojs#managing-aql-user-functions)

    // TODO: Arbitrary HTTP routes (https://github.com/arangodb/arangojs#arbitrary-http-routes)


}
