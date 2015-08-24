package com.emikra.vertx.arangodb.http.database.data;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@DataObject
public class CreateDatabaseOptions {

    public String name;
    private JsonArray users;

    public CreateDatabaseOptions() {

    }

    public CreateDatabaseOptions(CreateDatabaseOptions options) {

    }

    public CreateDatabaseOptions(JsonObject json) {

    }

    public void addUser(String username) {
        addUser(username, null);
    }

    public void addUser(String username, String password) {
        addUser(username, password, null);
    }

    public void addUser(String username, String password, Boolean active) {
        addUser(username, password, active, null);
    }

    public void addUser(String username, String password, Boolean active, JsonObject extra) {
        JsonObject user = new JsonObject();
        user.put("username", user);

        if (password != null) {
            user.put("passwd", password);
        }

        if (active != null) {
            user.put("active", active);
        }

        if (extra != null) {
            user.put("extra", extra);
        }

        users.add(user);
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.put("name", this.name);
        if (users != null) json.put("users", this.users);
        return json;
    }
}
