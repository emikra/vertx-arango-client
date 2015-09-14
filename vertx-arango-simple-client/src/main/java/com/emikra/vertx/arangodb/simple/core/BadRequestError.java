package com.emikra.vertx.arangodb.simple.core;

public class BadRequestError extends SimpleArangoHttpError {
    public BadRequestError() {
        super(400);
    }
}
