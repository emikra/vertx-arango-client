package com.emikra.vertx.arangodb.http.database.data;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetDatabaseInfoResponse extends ArangoResponse {

    private JsonObject result;

    public GetDatabaseInfoResponse() {

    }

    public GetDatabaseInfoResponse(GetDatabaseInfoResponse response) {

    }

    public GetDatabaseInfoResponse(JsonObject json) {
        super(json);

        if (this.isSuccess()) {
            result = json.getJsonObject("result");
        }
    }

    public String getName() {
        return this.result.getString("name");
    }

    public String getId() {
        return this.result.getString("id");
    }

    public String getPath() {
        return this.result.getString("path");
    }

    public Boolean getIsSystem() {
        return this.result.getBoolean("isSystem");
    }
}
