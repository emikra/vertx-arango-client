package com.emikra.vertx.arangodb.http.collection.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateCollectionOptions {

    public String name;
    public Boolean waitForSync;
    public Boolean doCompact;
    public Integer journalSize;
    public Boolean isSystem;
    public Boolean isVolatile;
    public JsonArray keyOptions;
    public CollectionType type;
    public Integer numberOfShards;
    public JsonArray shardKeys;

    public CreateCollectionOptions() {

    }

    public CreateCollectionOptions(CreateCollectionOptions options) {

    }

    public CreateCollectionOptions(JsonObject json) {

    }


    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        putIfNotNull(json, "name", name);
        putIfNotNull(json, "waitForSync", waitForSync);
        putIfNotNull(json, "doCompact", doCompact);
        putIfNotNull(json, "journalSize", journalSize);
        putIfNotNull(json, "isSystem", isSystem);
        putIfNotNull(json, "isVolatile", isVolatile);
        putIfNotNull(json, "keyOptions", keyOptions);

        if (type != null) {
            json.put("type", type.getCode());
        }
        putIfNotNull(json, "numberOfShards", numberOfShards);
        putIfNotNull(json, "shardKeys", shardKeys);
        return json;
    }

    public void putIfNotNull(JsonObject json, String key, Object value) {
        if (value != null) {
            json.put(key, value);
        }
    }


}
