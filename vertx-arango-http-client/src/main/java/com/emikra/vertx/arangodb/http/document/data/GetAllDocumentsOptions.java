package com.emikra.vertx.arangodb.http.document.data;


import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetAllDocumentsOptions {

    public String collection;
    public Type type;

    public GetAllDocumentsOptions() {

    }

    public GetAllDocumentsOptions(GetAllDocumentsOptions options) {

    }

    public GetAllDocumentsOptions(JsonObject json) {

    }

    public enum Type {
        ID("id"),
        KEY("key"),
        PATH("path");

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("collection", collection);

        if (type != null) {
            json.put("type", type.getValue());
        }

        return json;
    }
}
