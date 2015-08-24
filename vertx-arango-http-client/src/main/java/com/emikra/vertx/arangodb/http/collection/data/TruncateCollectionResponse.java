package com.emikra.vertx.arangodb.http.collection.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class TruncateCollectionResponse extends ArangoResponse {

    public TruncateCollectionResponse() {

    }

    public TruncateCollectionResponse(TruncateCollectionResponse response) {

    }

    public TruncateCollectionResponse(JsonObject json) {
        super(json);
    }

    public String getId() {
        return this.body.getString("id");
    }

    public Boolean getIsSystem() {
        return this.body.getBoolean("isSystem");
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
}
