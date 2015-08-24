package com.emikra.vertx.arangodb.http.query.simple.data;

import io.vertx.core.json.JsonObject;

public class ByExampleOptions extends SimpleQueryExampleOptions {

    /**
     * The number of documents to skip in the query (optional)
     */
    public Integer skip;

    /**
     * Max number of documents to return. The {@link #skip} is applied before the limit restriction (optional)
     */
    public Integer limit;

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("skip", this.skip);
        json.put("limit", this.limit);
        json.mergeIn(super.toJson());
        return json;
    }

}
