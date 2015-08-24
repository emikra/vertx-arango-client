package com.emikra.vertx.arangodb.http.query.simple.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import com.emikra.vertx.arangodb.http.data.Document;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedList;
import java.util.List;

public class SimpleQueryCursorResponse extends ArangoResponse {

    public SimpleQueryCursorResponse(JsonObject json) {
        super(json);
    }

    public JsonArray getJsonDocuments() {
        return this.body.getJsonArray("result");
    }

    public List<Document> getDocuments() {

        JsonArray json = getJsonDocuments();
        List<Document> documents = new LinkedList<>();

        for (int i = 0; i < json.size(); i++) {
            documents.add(new Document(json.getJsonObject(i)));
        }

        return documents;
    }

    public Boolean getHasMore() {
        return this.body.getBoolean("hasMore");
    }

    public String getId() {
        return this.body.getString("id");
    }
}
