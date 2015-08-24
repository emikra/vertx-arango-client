package com.emikra.vertx.arangodb.integration;

import com.emikra.vertx.arangodb.http.ArangoHttpClientOptions;
import com.emikra.vertx.arangodb.simple.core.SimpleArangoClient;
import com.emikra.vertx.arangodb.simple.core.SimpleArangoCollection;
import com.emikra.vertx.arangodb.simple.core.SimpleArangoDatabase;
import io.vertx.core.Vertx;
import io.vertx.test.core.VertxTestBase;
import org.junit.Before;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SimpleArangoClientITBase extends VertxTestBase {

    private static final int DEFAULT_ARANGO_PORT = 8529;
    private static final String SYSTEM_DB = "_system";
    private static final String TEST_DB = "test-simple-arango-client";
    private static final String TEST_COLLECTION = "test-collection";

    private boolean setUpCalled;
    private SimpleArangoClient client;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        ArangoHttpClientOptions options = new ArangoHttpClientOptions()
                .setHost("localhost")
                .setPort(DEFAULT_ARANGO_PORT)
                .setUsername("root")
                .setDatabase("_system");

        client = new SimpleArangoClient(Vertx.vertx(), options);
        setUpCalled = true;
    }

    protected SimpleArangoClient client() {
        return client;
    }

    protected void createTestDatabase() throws Exception {
        ensureSetUpCalled();
        CountDownLatch latch = new CountDownLatch(1);
        client.createDatabase(TEST_DB, res -> latch.countDown());
        latch.await(5, TimeUnit.SECONDS);
    }

    protected void dropTestDatabase() throws Exception {
        ensureSetUpCalled();
        CountDownLatch latch = new CountDownLatch(1);
        client.dropDatabase(TEST_DB, res -> latch.countDown());
        latch.await(5, TimeUnit.SECONDS);
    }

    protected SimpleArangoDatabase testDatabase() {
        return client.db(TEST_DB);
    }

    protected void createTestCollection() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        testDatabase().createCollection(TEST_COLLECTION, res -> latch.countDown());
        latch.await(5, TimeUnit.SECONDS);
    }

    protected SimpleArangoCollection testCollection() {
        return testDatabase().coll(TEST_COLLECTION);
    }

    private void ensureSetUpCalled() {
        if(!setUpCalled) {
            throw new IllegalStateException("super.setUp() was never called. Please call it in a @Before method in this class.");
        }
    }
}
