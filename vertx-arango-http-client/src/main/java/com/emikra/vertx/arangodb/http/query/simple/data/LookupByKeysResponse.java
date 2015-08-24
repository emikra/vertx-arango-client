package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import com.emikra.vertx.arangodb.http.data.Document;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

public class LookupByKeysResponse extends ArangoResponse {

    public LookupByKeysResponse(JsonObject json) {
        super(json);
    }

    public JsonArray getJsonDocuments() {
        return this.body.getJsonArray("documents");
    }

    public List<Document> getDocuments() {

        JsonArray json = getJsonDocuments();
        List<Document> documents = new LinkedList<>();

        for (int i = 0; i < json.size(); i++) {
            documents.add(new Document(json.getJsonObject(i)));
        }

        return documents;
    }

}
