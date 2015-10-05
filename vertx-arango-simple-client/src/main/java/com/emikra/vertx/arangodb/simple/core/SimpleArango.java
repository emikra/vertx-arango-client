package com.emikra.vertx.arangodb.simple.core;

import com.emikra.vertx.arangodb.http.ArangoError;
import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class SimpleArango {

    static <T extends ArangoResponse> Handler<AsyncResult<T>> wrapHandler(Handler<AsyncResult<T>> handler) {
        return res -> {
            T ar = res.result();
            Future<T> future;

            if (res.failed()) {
                future = Future.failedFuture(res.cause());
            } else if (ar.httpStatus() != null && ar.httpStatus() >= 400) {
                SimpleArangoHttpError ex;

                switch (ar.httpStatus()) {
                    case 400:
                        ex = new BadRequestError();
                        break;
                    case 404:
                        ex = new NotFoundError();
                        break;
                    case 500:
                        ex = new InternalServerError();
                        break;
                    default:
                        ex = new SimpleArangoHttpError(ar.httpStatus());
                        break;
                }

                future = Future.failedFuture(ex);
            } else if (ar.isError()) {
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

    public static <T> Handler<AsyncResult<T>> futureHandler(Future<T> future) {
        return res -> {
            if (res.succeeded()) {
                future.complete(res.result());
            } else {
                future.fail(res.cause());
            }
        };
    }

    public static boolean isArangoError(Throwable t, int errorNum) {
        if (t instanceof ArangoError) {
            ArangoError ae = (ArangoError) t;
            return (ae.errorNum == errorNum);
        }
        return false;
    }
}
