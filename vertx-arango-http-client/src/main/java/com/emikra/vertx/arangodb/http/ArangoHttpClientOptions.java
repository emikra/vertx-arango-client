package com.emikra.vertx.arangodb.http;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ArangoHttpClientOptions {

    private JsonObject json;

    public ArangoHttpClientOptions() {
        this.json = new JsonObject();
    }

    public ArangoHttpClientOptions(ArangoHttpClientOptions options) {
        this(options.json);
    }

    public ArangoHttpClientOptions(JsonObject json) {
        this.json = (json != null) ? json.copy() : new JsonObject();
    }

    public JsonObject toJson() {
        return this.json.copy();
    }

    public String getHost() {
        return this.json.getString("host");
    }

    public ArangoHttpClientOptions setHost(String host) {
        this.json.put("host", host);
        return this;
    }

    public Integer getPort() {
        return this.json.getInteger("port");
    }

    public ArangoHttpClientOptions setPort(int port) {
        this.json.put("port", port);
        return this;
    }

    public String getUsername() {
        return this.json.getString("username");
    }

    public ArangoHttpClientOptions setUsername(String username) {
        this.json.put("username", username);
        return this;
    }

    public String getPassword() {
        return this.json.getString("password");
    }

    public ArangoHttpClientOptions setPassword(String password) {
        this.json.put("password", password);
        return this;
    }

    public String getDatabase() {
        return this.json.getString("database");
    }

    public ArangoHttpClientOptions setDatabase(String databaseName) {
        this.json.put("database", databaseName);
        return this;
    }
}
