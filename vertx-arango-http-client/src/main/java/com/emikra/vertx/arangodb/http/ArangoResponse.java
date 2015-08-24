package com.emikra.vertx.arangodb.http;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ArangoResponse {

    public ArangoError error;
    protected Integer httpStatus;
    protected JsonObject body;
    protected ArangoHeaders headers;

    public ArangoResponse() {
        this(new JsonObject());
    }

    public ArangoResponse(ArangoResponse response) {
        this(response.toJson());
    }

    public ArangoResponse(JsonObject json) {
        this.body = json;

        this.httpStatus = json.getInteger("status");
        this.body = json.getJsonObject("body", new JsonObject());
        this.headers = new ArangoHeaders(json.getJsonObject("headers", new JsonObject()));

        isError();
    }

    public Boolean isError() {
        if (body.containsKey("error") && body.getBoolean("error", false)) {
            this.error =  new ArangoError(this.body());
            return true;
        }
        return false;
    }

    public Boolean isSuccess() {
        return !isError();
    }

    public Integer getCode() {
        return this.body.getInteger("code");
    }

    public Boolean getError() {
        return this.body.getBoolean("error");
    }

    public JsonObject toJson() {
        return new JsonObject()
                .put("status", httpStatus)
                .put("headers", headers())
                .put("body", body());
    }

    public Integer httpStatus() {
        return this.httpStatus;
    }

    public JsonObject body() {
        return this.body.copy();
    }

    public JsonObject headers() {
        return this.headers.toJson();
    }

}