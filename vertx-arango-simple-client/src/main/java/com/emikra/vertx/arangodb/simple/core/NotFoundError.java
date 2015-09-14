package com.emikra.vertx.arangodb.simple.core;

public class NotFoundError extends SimpleArangoHttpError {
    public NotFoundError() {
        super(404);
    }
}
