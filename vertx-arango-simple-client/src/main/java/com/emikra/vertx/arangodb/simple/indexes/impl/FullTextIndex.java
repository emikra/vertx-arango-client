package com.emikra.vertx.arangodb.simple.indexes.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.index.data.FullTextIndexResponse;
import com.emikra.vertx.arangodb.simple.indexes.Index;
import com.emikra.vertx.arangodb.simple.indexes.IndexType;
import io.vertx.core.json.JsonObject;

public class FullTextIndex extends Index<FullTextIndexResponse, FullTextIndex> {
    private int minLength;

    public FullTextIndex(ArangoHttpClient client, String collection) {
        super(client, collection, IndexType.FullText);
    }

    @Override
    protected FullTextIndex getThis() {
        return this;
    }

    public FullTextIndex minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public int getMinLength() {
        return minLength;
    }

    @Override
    protected void appendJson(JsonObject json) {
        json.put("minLength", minLength);
    }
}
