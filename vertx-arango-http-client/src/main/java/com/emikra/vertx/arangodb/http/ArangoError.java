package com.emikra.vertx.arangodb.http;

import io.vertx.core.json.JsonObject;

public class ArangoError extends RuntimeException {

    public Integer errorNum;
    public String errorMessage;

    public ArangoError(JsonObject json) {
        super(String.format("[%d] %s", json.getInteger("errorNum"), json.getString("errorMessage")));
        this.errorNum = json.getInteger("errorNum");
        this.errorMessage = json.getString("errorMessage");
    }
}
