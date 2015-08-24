package com.emikra.vertx.arangodb.http.index.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateCapConstraintOptions extends CreateIndexOptions {

    public final String FIELD_SIZE = "size";
    public final String FIELD_BYTE_SIZE = "byteSize";

    public CreateCapConstraintOptions() {
        this(new JsonObject());
    }

    public CreateCapConstraintOptions(CreateCapConstraintOptions options) {
        this(options.toJson());
    }

    public CreateCapConstraintOptions(JsonObject json) {
        super(json);
        this.setType("cap");
    }

    public CreateCapConstraintOptions setSize(Integer size) {
        this.getJson().put(FIELD_SIZE, size);
        return this;
    }

    public CreateCapConstraintOptions setByteSize(Integer byteSize) {
        this.getJson().put(FIELD_BYTE_SIZE, byteSize);
        return this;
    }

    public Integer getSize() {
        return this.getJson().getInteger(FIELD_SIZE);
    }

    public Integer getByteSize() {
        return this.getJson().getInteger(FIELD_BYTE_SIZE);
    }
}
