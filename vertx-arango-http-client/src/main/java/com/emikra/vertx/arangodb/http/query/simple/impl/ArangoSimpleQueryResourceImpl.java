package com.emikra.vertx.arangodb.http.query.simple.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.query.simple.ArangoSimpleQueryResource;
import com.emikra.vertx.arangodb.http.query.simple.data.*;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public class ArangoSimpleQueryResourceImpl implements ArangoSimpleQueryResource {

    private ArangoHttpClientConnection conn;

    public ArangoSimpleQueryResourceImpl(ArangoHttpClientConnection connection) {
        this.conn = connection;
    }

    @Override
    public void any(AnyOptions options, Handler<AsyncResult<AnyResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/any", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new AnyResponse(response.toJson()))))
                        .end();
    }

    @Override
    public void all(AllOptions options, Handler<AsyncResult<AllResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/all", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new AllResponse(response.toJson()))))
                .end();
    }

    @Override
    public void byExample(ByExampleOptions options, Handler<AsyncResult<ByExampleResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/by-example", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new ByExampleResponse(response.toJson()))))
                .end();
    }

    @Override
    public void firstExample(FirstExampleOptions options, Handler<AsyncResult<FirstExampleResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/first-example", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new FirstExampleResponse(response.toJson()))))
                        .end();
    }

    @Override
    public void first(FirstOptions options, Handler<AsyncResult<FirstResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/first", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new FirstResponse(response.toJson()))))
                .end();
    }

    @Override
    public void fullText(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {
        throw new UnsupportedOperationException("This method is deprecated.");
    }

    @Override
    public void last(LastOptions options, Handler<AsyncResult<LastResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/list", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new LastResponse(response.toJson()))))
                        .end();
    }

    @Override
    public void lookupByKeys(LookupByKeysOptions options, Handler<AsyncResult<LookupByKeysResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/lookup-by-keys", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new LookupByKeysResponse(response.toJson()))))
                .end();
    }

    @Override
    public void near(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {
        throw new UnsupportedOperationException("This method is deprecated.");
    }

    @Override
    public void range(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .put("/_api/simple/range", options)
                .handler(response -> handler.handle(Future.succeededFuture(response.toJson())))
                .end();
    }

    @Override
    public void removeByKeys(RemoveByKeysOptions options, Handler<AsyncResult<RemoveByKeysResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/remove-by-keys", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new RemoveByKeysResponse(response.toJson()))))
                .end();
    }

    @Override
    public void removeByExample(RemoveByExampleOptions options, Handler<AsyncResult<RemoveByExampleResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/remove-by-example", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new RemoveByExampleResponse(response.toJson()))))
                .end();
    }

    @Override
    public void replaceByExample(ReplaceByExampleOptions options, Handler<AsyncResult<ReplaceByExampleResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/replace-by-example", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new ReplaceByExampleResponse(response.toJson()))))
                .end();
    }

    @Override
    public void updateByExample(UpdateByExampleOptions options, Handler<AsyncResult<UpdateByExampleResponse>> handler) {

        this.conn.client()
                .put("/_api/simple/update-by-example", options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new UpdateByExampleResponse(response.toJson()))))
                .end();
    }

    @Override
    public void within(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {
        throw new UnsupportedOperationException("This method is deprecated.");
    }
}
