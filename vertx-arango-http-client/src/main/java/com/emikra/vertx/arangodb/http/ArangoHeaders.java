package com.emikra.vertx.arangodb.http;

import io.vertx.core.json.JsonObject;

import java.util.Map;
import java.util.TreeMap;

public class ArangoHeaders {

    private Map<String, Object> headers;

    public ArangoHeaders(JsonObject json) {
        this(json.getMap());
    }

    public ArangoHeaders(Map<String, Object> headers) {
        this.headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        this.headers.putAll(headers);
    }

    public String get(String key) {
        return (String) headers.get(key);
    }

    public JsonObject toJson() {
        return new JsonObject(this.headers);
    }
}
