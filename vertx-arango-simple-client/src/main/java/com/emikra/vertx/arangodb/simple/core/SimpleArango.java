package com.emikra.vertx.arangodb.simple.core;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

class SimpleArango {

    static <T extends ArangoResponse> Handler<AsyncResult<T>> wrapHandler(Handler<AsyncResult<T>> handler) {
        return res -> {
            T ar = res.result();
            Future<T> future;

            if(res.failed()) {
                future = Future.failedFuture(res.cause());
            }
            else if(ar.isError()) {
                future = Future.failedFuture(ar.error);
            } else {
                future = Future.succeededFuture(ar);
            }

            handler.handle(future);
        };
    }

    public static String documentHandle(String collectionName, String key) {
        return collectionName + "/" + key;
    }
}
