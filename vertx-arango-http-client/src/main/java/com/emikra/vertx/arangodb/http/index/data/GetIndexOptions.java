package com.emikra.vertx.arangodb.http.index.data;

import com.emikra.vertx.arangodb.http.ArangoOptions;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetIndexOptions extends ArangoOptions {

    public GetIndexOptions() {
        this(new JsonObject());
    }

    public GetIndexOptions(GetIndexOptions options) {
        this(options.toJson());
    }

    public GetIndexOptions(JsonObject json) {
        super(json);
    }
}
