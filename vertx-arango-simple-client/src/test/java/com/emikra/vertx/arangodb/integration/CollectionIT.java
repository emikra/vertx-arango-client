package com.emikra.vertx.arangodb.integration;

import com.emikra.vertx.arangodb.simple.util.ArangoUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CollectionIT extends SimpleArangoClientITBase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        createTestDatabase();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        dropTestDatabase();
    }

    @Test
    public void canCreateAndDropCollection() {
        String collectionName = "test-new-collection";

        testDatabase().createCollection(collectionName, createRes -> {
            assertTrue(ArangoUtil.isSuccess(createRes));
            // Dropping the db is implicitly a check to ensure it was created
            testDatabase().dropCollection(collectionName, dropRes -> {
                assertTrue(ArangoUtil.isSuccess(dropRes));
                testComplete();
            });
        });

        await();
    }
}
