package com.emikra.vertx.arangodb.http.query.aql.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.query.aql.ArangoAqlQueryInspectionResource;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public class ArangoAqlQueryInspectionResourceImpl implements ArangoAqlQueryInspectionResource {

    private ArangoHttpClientConnection conn;

    public ArangoAqlQueryInspectionResourceImpl(ArangoHttpClientConnection connection) {
        this.conn = connection;
    }

    @Override
    public void explain(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .post("/_api/explain", options)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void kill(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .post("/_api/query/:queryId", options)
                .param("queryId", options.getString("queryId"))
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void query(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .post("/_api/query", options)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void getCurrentQueries(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .get("/_api/query/properties")
                .param(options)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void getSlowQueries(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .get("/_api/query/properties")
                .param(options)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void clearSlowQueries(Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .delete("/_api/query/properties")
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void getTrackingConfiguration(Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .get("/_api/query/properties")
                .handler(response -> Future.succeededFuture(response))
                .end();
    }

    @Override
    public void updateTrackingConfiguration(JsonObject options, Handler<AsyncResult<JsonObject>> handler) {

        this.conn.client()
                .put("/_api/aqlfunction", options)
                .handler(response -> Future.succeededFuture(response))
                .end();
    }
}
