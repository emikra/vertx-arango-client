package com.emikra.vertx.arangodb.http.integration.database;

import org.junit.Test;

public class ArangoCreateDatabaseIT extends ArangoDatabaseITBase {

    @Test
    public void testCreateDatabase() {
        httpClient.database(db -> {
            db.result().create("test_database", createResponse -> {
                System.out.println(createResponse.result().toJson().encodePrettily());
            });
        });
    }
}
