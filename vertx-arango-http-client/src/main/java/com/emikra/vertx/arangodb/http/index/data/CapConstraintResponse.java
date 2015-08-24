package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class CapConstraintResponse extends GetIndexResponse {

    public final String FIELD_SIZE = "size";
    public final String FIELD_BYTE_SIZE = "byteSize";
    public final String FIELD_UNIQUE = "unique";

    public CapConstraintResponse() {
        this(new JsonObject());
    }

    public CapConstraintResponse(CapConstraintResponse response) {
        this(response.toJson());
    }

    public CapConstraintResponse(JsonObject json) {
        super(json);
    }

    public Integer getSize() {
        return this.body.getInteger(FIELD_SIZE);
    }

    public Integer getByteSize() {
        return this.body.getInteger(FIELD_BYTE_SIZE);
    }

    public Boolean getUnique() {
        return this.body.getBoolean(FIELD_UNIQUE);
    }
}
