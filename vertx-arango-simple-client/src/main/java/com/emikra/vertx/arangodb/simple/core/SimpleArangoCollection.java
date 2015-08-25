package com.emikra.vertx.arangodb.simple.core;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.document.data.*;
import com.emikra.vertx.arangodb.http.query.simple.data.AllOptions;
import com.emikra.vertx.arangodb.http.query.simple.data.AllResponse;
import com.emikra.vertx.arangodb.http.query.simple.data.ByExampleOptions;
import com.emikra.vertx.arangodb.http.query.simple.data.ByExampleResponse;
import com.emikra.vertx.arangodb.simple.indexes.impl.FullTextIndex;
import com.emikra.vertx.arangodb.simple.indexes.impl.GeoSpatialIndex;
import com.emikra.vertx.arangodb.simple.indexes.impl.HashIndex;
import com.emikra.vertx.arangodb.simple.indexes.impl.SkipListIndex;
import com.emikra.vertx.arangodb.simple.util.ArangoUtil;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public class SimpleArangoCollection {

    private ArangoHttpClient arango;
    private String collection;

    SimpleArangoCollection(ArangoHttpClient arango, String collection) {
        this.arango = arango;
        this.collection = collection;
    }

    public String getName() {
        return this.collection;
    }

    public HashIndex newHashIndex() {
        return new HashIndex(arango, collection);
    }

    public SkipListIndex newSkipListIndex() {
        return new SkipListIndex(arango, collection);
    }

    public GeoSpatialIndex newGeoIndex() {
        return new GeoSpatialIndex(arango, collection);
    }

    public FullTextIndex newFullTextIndex() {
        return new FullTextIndex(arango, collection);
    }

    public void createDocument(JsonObject document, Handler<AsyncResult<CreateDocumentResponse>> resultHandler) {
        arango.document(res -> res.result().create(collection, document, resultHandler));
    }

    public void patchDocument(String key, JsonObject document, Handler<AsyncResult<PatchDocumentResponse>> resultHandler) {
        arango.document(res -> res.result().patch(ArangoUtil.documentHandle(collection, key), document, resultHandler));
    }

    public void replaceDocument(String key, JsonObject document, Handler<AsyncResult<ReplaceDocumentResponse>> resultHandler) {
        arango.document(res -> res.result().replace(ArangoUtil.documentHandle(collection, key), document, resultHandler));
    }

    public void removeDocument(String key, Handler<AsyncResult<RemoveDocumentResponse>> resultHandler) {
        arango.document(res -> res.result().remove(ArangoUtil.documentHandle(collection, key), resultHandler));
    }

    public void all(Handler<AsyncResult<AllResponse>> resultHandler) {
        arango.simpleQuery(res -> {
            AllOptions options = new AllOptions();
            options.collection = collection;
            res.result().all(options, resultHandler);
        });
    }

    public void byExample(JsonObject example, Handler<AsyncResult<ByExampleResponse>> resultHandler) {
        byExample(example, 0, 0, resultHandler);
    }

    public void byExample(JsonObject example, int limit, Handler<AsyncResult<ByExampleResponse>> resultHandler) {
        byExample(example, limit, 0, resultHandler);
    }

    public void byExample(JsonObject example, int limit, int skip, Handler<AsyncResult<ByExampleResponse>> resultHandler) {
        arango.simpleQuery(res -> {
            ByExampleOptions options = new ByExampleOptions();
            options.collection = collection;
            options.example = example;
            options.limit = (limit == 0 ? null : limit);
            options.skip = (skip == 0 ? null : skip);
            res.result().byExample(options, resultHandler);
        });
    }
}
