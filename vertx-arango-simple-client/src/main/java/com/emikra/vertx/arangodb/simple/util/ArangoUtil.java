package com.emikra.vertx.arangodb.simple.util;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.ArangoResponse;
import com.emikra.vertx.arangodb.simple.core.SimpleArangoClient;
import io.vertx.core.AsyncResult;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

/**
 * Various helper methods to simplify working with ArangoDB.
 */
public final class ArangoUtil {

    private static final Logger log = LoggerFactory.getLogger(ArangoUtil.class);

    /**
     * Creates a document handle string (a unique identifier for an specific ArangoDB document within a database)
     * suitable for use in various {@link ArangoHttpClient}
     * and {@link SimpleArangoClient} methods.
     *
     * @param collectionName The name of the database collection containing the document to create a handle for
     * @param key            The key of the specific document within the collection specified by <tt>collectionName</tt>
     * @return A document handle in the format <tt>{collectionName}/{key}</tt>
     */
    public static String documentHandle(String collectionName, String key) {
        return collectionName + "/" + key;
    }

    /**
     * Returns <tt>true</tt> if the specified {@link AsyncResult}
     * represents a "success" result. This means the underlying {@link AsyncResult} is
     * not a failure result, and that the underlying {@link ArangoResponse} does not
     * contain an error.
     * <p/>
     * In addition, if the result is a failure result (as defined above), the error details
     * will be logged in the application log.
     *
     * @param result The {@link AsyncResult} to check.
     * @return <tt>true</tt> if the result is a successful response, <tt>false</tt> otherwise
     */
    public static boolean isSuccess(AsyncResult<? extends ArangoResponse> result) {
        if (result.failed()) {
            log.error(result.cause());
            return false;
        }

        ArangoResponse resp = result.result();

        if (resp.isError()) {
            log.error(resp.error);
        }
        return !resp.isError();
    }

    /**
     * Throws an exception if the specified {@link AsyncResult}
     * represents a "failure" result. This means the underlying {@link AsyncResult} is
     * a failure result, or that the underlying {@link ArangoResponse}
     * represents an ArangoDB error.
     *
     * @param result The {@link AsyncResult} to check.
     */
    public static void validateResult(AsyncResult<? extends ArangoResponse> result) throws Throwable {
        if (result.failed()) {
            log.error(result.cause());
            throw result.cause();
        }

        ArangoResponse resp = result.result();

        if (resp.isError()) {
            log.error(resp.error);
            // TODO Convert to relevant exception subclass based on error code?
            throw resp.error;
        }
    }
}
