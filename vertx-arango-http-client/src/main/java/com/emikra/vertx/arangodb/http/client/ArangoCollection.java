package com.emikra.vertx.arangodb.http.client;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public interface ArangoCollection {

    void properties(Handler<AsyncResult<JsonObject>> handler);

    void count(Handler<AsyncResult<JsonObject>> handler);

    void figures(Handler<AsyncResult<JsonObject>> handler);

    void revision(Handler<AsyncResult<JsonObject>> handler);

    void checksum(Handler<AsyncResult<JsonObject>> handler);

    void load(Boolean count, Handler<AsyncResult<JsonObject>> handler);

    void unload(Handler<AsyncResult<JsonObject>> handler);

    void setProperties(JsonObject properties, Handler<AsyncResult<JsonObject>> handler);

    void rename(String name, Handler<AsyncResult<JsonObject>> handler);

    void rotate(Handler<AsyncResult<JsonObject>> handler);

    void truncate(Handler<AsyncResult<JsonObject>> handler);

    void drop(Handler<AsyncResult<JsonObject>> handler);

    // TODO: Manipulating indexes (https://github.com/arangodb/arangojs#manipulating-indexes)

    // TODO: Full text queries (https://github.com/arangodb/arangojs#fulltext-queries)

    // TODO: Geo queries (https://github.com/arangodb/arangojs#geo-queries)

    // TODO: Bulk importing queries (https://github.com/arangodb/arangojs#bulk-importing-documents)

    void replace(String documentHandle, JsonObject document, JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void update(String documentHandle, JsonObject document, JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void remove(String documentHandle, JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void all(String type, Handler<AsyncResult<JsonObject>> handler);


}
