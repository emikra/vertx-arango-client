package com.emikra.vertx.arangodb.http.query.aql;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public interface ArangoAqlQueryInspectionResource {

    void explain(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void kill(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void query(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void getCurrentQueries(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void getSlowQueries(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

    void clearSlowQueries(Handler<AsyncResult<JsonObject>> handler);

    void getTrackingConfiguration(Handler<AsyncResult<JsonObject>> handler);

    void updateTrackingConfiguration(JsonObject options, Handler<AsyncResult<JsonObject>> handler);

}
