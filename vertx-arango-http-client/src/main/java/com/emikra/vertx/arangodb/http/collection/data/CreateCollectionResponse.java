package com.emikra.vertx.arangodb.http.collection.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateCollectionResponse extends ArangoResponse {

    public CreateCollectionResponse() {

    }

    public CreateCollectionResponse(CreateCollectionResponse response) {

    }

    public CreateCollectionResponse(JsonObject json) {
        super(json);
    }

    public String getId() {
        return this.body.getString("id");
    }

    public String getName() {
        return this.body.getString("name");
    }

    public Boolean getWaitForSync() {
        return this.body.getBoolean("waitForSync");
    }

    public Boolean getIsSystem() {
        return this.body.getBoolean("isSystem");
    }

    public Boolean getIsVolatile() {
        return this.body.getBoolean("isVolatile");
    }

    public Integer getStatus() {
        return this.body.getInteger("status");
    }

    public Integer getTypeCode() {
        return this.body.getInteger("type");
    }

    public CollectionType getType() {
        return CollectionType.getByCode(getTypeCode());
    }

    public JsonObject toJson() {
        return null;
    }

}
