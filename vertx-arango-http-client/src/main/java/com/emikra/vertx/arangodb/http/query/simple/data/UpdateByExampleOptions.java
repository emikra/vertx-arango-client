package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class UpdateByExampleOptions extends SimpleQueryExampleOptions {

    public JsonObject newValue;

    public Boolean keepNull;

    public Boolean waitForSync;

    public Integer limit;
}
