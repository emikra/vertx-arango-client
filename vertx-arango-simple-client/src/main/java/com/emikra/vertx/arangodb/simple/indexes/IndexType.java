package com.emikra.vertx.arangodb.simple.indexes;

public enum IndexType {
    Hash("hash"),
    SkipList("skiplist"),
    Geo("geo"),
    FullText("fulltext");

    private String value;

    private IndexType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}

