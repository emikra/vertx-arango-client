package com.emikra.vertx.arangodb.http.collection.data;

public enum CollectionType {
    DOCUMENT(2),
    EDGE(3);

    private int code;

    CollectionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static CollectionType getByCode(int code) {
        CollectionType type = null;
        for (CollectionType t : CollectionType.values()) {
            if (t.code == code) {
                type = t;
                break;
            }
        }
        return type;
    }
}