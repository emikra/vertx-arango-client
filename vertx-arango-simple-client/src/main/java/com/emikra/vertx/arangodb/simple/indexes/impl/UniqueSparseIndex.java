package com.emikra.vertx.arangodb.simple.indexes.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.index.data.GetIndexResponse;
import com.emikra.vertx.arangodb.simple.indexes.Index;
import com.emikra.vertx.arangodb.simple.indexes.IndexType;
import io.vertx.core.json.JsonObject;

public abstract class UniqueSparseIndex<T extends GetIndexResponse, I extends Index> extends Index<T, I> {
    private boolean unique;
    private boolean sparse;

    public UniqueSparseIndex(ArangoHttpClient client, String collection, IndexType type) {
        super(client, collection, type);
    }

    public I unique() {
        this.unique = true;
        return getThis();
    }

    public I sparse() {
        this.sparse = true;
        return getThis();
    }

    public boolean isUnique() {
        return unique;
    }

    public boolean isSparse() {
        return sparse;
    }

    @Override
    protected void appendJson(JsonObject json) {
        json.put("unique", unique);
        json.put("sparse", sparse);
    }
}
