package com.emikra.vertx.arangodb.simple.indexes;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.index.data.CreateIndexOptions;
import com.emikra.vertx.arangodb.http.index.data.GetIndexResponse;
import com.emikra.vertx.arangodb.simple.core.SimpleArango;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.Arrays;

public abstract class Index<T extends GetIndexResponse, I extends Index> {

    private final ArangoHttpClient client;
    private final String collection;
    private final IndexType type;

    private String[] fields;

    protected Index(ArangoHttpClient client, String collection, IndexType type) {
        this.client = client;
        this.collection = collection;
        this.type = type;
    }

    public I on(String... fields) {
        this.fields = fields;
        return getThis();
    }

    public String[] getFields() {
        return fields;
    }

    public IndexType getType() {
        return type;
    }

    protected abstract void appendJson(JsonObject json);
    protected abstract I getThis();

    private JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("type", type.value());
        json.put("fields", new JsonArray(Arrays.asList(fields)));
        appendJson(json);
        return json;
    }

    /**
     * Submits a request to Arango <tt>index</tt> HTTP API to create this index.
     * When <tt>resultHandler.handle()</tt> is called, the <tt>AsyncResult</tt>
     * parameter's {@link AsyncResult#succeeded()} will return <tt>true</tt> as long
     * as the Arango HTTP API returned a valid HTTP response. Otherwise,
     * it @{AsyncResult#failed()} will return <tt>true</tt>.
     *
     * @param resultHandler The {@link Handler} that will receive the result of the request.
     */
    @SuppressWarnings("unchecked")
    public void create(Handler<AsyncResult<T>> resultHandler) {
        CreateIndexOptions opts = new CreateIndexOptions(this.toJson());
        client.index(res -> res.result().create(collection, opts, createRes -> {
            T response = null;

            if (createRes.failed()) {
                resultHandler.handle(Future.failedFuture(createRes.cause()));
                return;
            }

            switch (this.type) {
                case Hash:
                    response = (T) createRes.result().getAsHashIndexResponse();
                    break;
                case SkipList:
                    response = (T) createRes.result().getAsSkipListIndexResponse();
                    break;
                case Geo:
                    response = (T) createRes.result().getAsGeoSpatialIndexResponse();
                case FullText:
                    response = (T) createRes.result().getAsFullTextIndexResponse();
            }

            Future<T> fut = Future.succeededFuture(response);
            resultHandler.handle(fut);
        }));
    }

    /**
     * Returns a {@link Future} that completes when the request to create this index
     * has completed. If the index creation fails for any reason, including getting an HTTP
     * error response from the Arango <tt>index</tt> API, the returned {@link Future} will complete exceptionally.
     *
     * @return A {@link Future} that completes with the corresponding {@link GetIndexResponse}
     * subclass representing the result returned from the Arango <tt>index</tt> API, if it is a success response.
     * Otherwise, {@link Future} the future fails with a throwable containing an error message.
     * @see #create(Handler)
     */
    public Future<T> create() {
        Future<T> f = Future.future();
        this.create(SimpleArango.futureHandler(f));
        return f;
    }
}
