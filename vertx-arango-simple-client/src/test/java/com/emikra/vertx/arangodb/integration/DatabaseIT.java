package com.emikra.vertx.arangodb.integration;

import org.junit.Test;

public class DatabaseIT extends SimpleArangoClientITBase {

    @Test
    public void canCreateAndDropDatabase() {
        String databaseName = "test-create-db";

        client().createDatabase(databaseName, createRes -> {
            assertTrue(createRes.succeeded());
            // Dropping the db is implicitly a check to ensure it was created
            client().dropDatabase(databaseName, dropRes -> {
                assertTrue(dropRes.succeeded());
                testComplete();
            });
        });

        await();
    }

    @Test
    public void databaseExistsReturnsTrue() {
        client().databaseExists(client().db().getName(), res -> {
            assertTrue(res.result());
            testComplete();
        });
    }

    @Test
    public void databaseExistsReturnsFalse() {
        client().databaseExists("non-existent-database", res -> {
            assertFalse(res.result());
            testComplete();
        });
    }
}
