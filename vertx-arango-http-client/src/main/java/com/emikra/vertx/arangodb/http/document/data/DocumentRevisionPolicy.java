package com.emikra.vertx.arangodb.http.document.data;

public enum DocumentRevisionPolicy {
    ERROR("error"),
    LAST("last");

    private String value;

    DocumentRevisionPolicy(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
