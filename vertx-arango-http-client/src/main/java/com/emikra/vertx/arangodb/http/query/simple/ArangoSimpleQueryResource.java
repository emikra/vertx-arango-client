package com.emikra.vertx.arangodb.http.query.simple;

import com.emikra.vertx.arangodb.http.query.simple.data.*;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public interface ArangoSimpleQueryResource {

    void any(AnyOptions options, Handler<AsyncResult<AnyResponse>> handler);

    void all(AllOptions options, Handler<AsyncResult<AllResponse>> handler);

    /**
     * This will find all documents matching a given example.
     */
    void byExample(ByExampleOptions options, Handler<AsyncResult<ByExampleResponse>> handler);

    void firstExample(FirstExampleOptions options, Handler<AsyncResult<FirstExampleResponse>> handler);

    void first(FirstOptions options, Handler<AsyncResult<FirstResponse>> handler);

    @Deprecated
    void fullText(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void last(LastOptions options, Handler<AsyncResult<LastResponse>> handler);

    void lookupByKeys(LookupByKeysOptions options, Handler<AsyncResult<LookupByKeysResponse>> handler);

    @Deprecated
    void near(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void range(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void removeByKeys(RemoveByKeysOptions options, Handler<AsyncResult<RemoveByKeysResponse>> handler);

    void removeByExample(RemoveByExampleOptions options, Handler<AsyncResult<RemoveByExampleResponse>> handler);

    void replaceByExample(ReplaceByExampleOptions options, Handler<AsyncResult<ReplaceByExampleResponse>> handler);

    void updateByExample(UpdateByExampleOptions options, Handler<AsyncResult<UpdateByExampleResponse>> handler);

    @Deprecated
    void within(JsonObject options, Handler<AsyncResult<JsonObject>> handler);
}
