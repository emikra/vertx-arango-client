package com.emikra.vertx.arangodb.http.index.data;

import com.emikra.vertx.arangodb.http.ArangoOptions;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class RemoveIndexOptions extends ArangoOptions {

    public RemoveIndexOptions() {
        super();
    }

    public RemoveIndexOptions(RemoveIndexOptions options) {
        super(options);
    }

    public RemoveIndexOptions(JsonObject json) {
        super(json);
    }
}
