package com.emikra.vertx.arangodb.simple.core;

public class InternalServerError extends SimpleArangoHttpError {
    public InternalServerError() {
        super(500);
    }
}
