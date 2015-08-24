package com.emikra.vertx.arangodb.simple.indexes.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.index.data.HashIndexResponse;
import com.emikra.vertx.arangodb.simple.indexes.IndexType;

public class HashIndex extends UniqueSparseIndex<HashIndexResponse, HashIndex> {
    public HashIndex(ArangoHttpClient client, String collection) {
        super(client, collection, IndexType.Hash);
    }

    @Override
    protected HashIndex getThis() {
        return this;
    }
}
