package com.emikra.vertx.arangodb.simple.indexes.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.index.data.SkipListIndexResponse;
import com.emikra.vertx.arangodb.simple.indexes.IndexType;

public class SkipListIndex extends UniqueSparseIndex<SkipListIndexResponse, SkipListIndex> {
    public SkipListIndex(ArangoHttpClient client, String collection) {
        super(client, collection, IndexType.SkipList);
    }

    @Override
    protected SkipListIndex getThis() {
        return this;
    }
}
