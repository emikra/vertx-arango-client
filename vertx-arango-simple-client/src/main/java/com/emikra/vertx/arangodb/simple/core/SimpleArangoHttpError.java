package com.emikra.vertx.arangodb.simple.core;

public class SimpleArangoHttpError extends RuntimeException {

    private int httpStatusCode;

    public SimpleArangoHttpError(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int httpStatusCode() {
        return httpStatusCode;
    }
}
