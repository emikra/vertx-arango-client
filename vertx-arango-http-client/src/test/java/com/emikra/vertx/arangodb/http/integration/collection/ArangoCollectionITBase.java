package com.emikra.vertx.arangodb.http.integration.collection;

import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionResponse;
import com.emikra.vertx.arangodb.http.integration.ArangoITBase;
import org.junit.BeforeClass;

import java.util.concurrent.CountDownLatch;

public class ArangoCollectionITBase extends ArangoITBase {

    protected static String collectionName;
    protected static CreateCollectionResponse createResponse;

    @BeforeClass
    public static void beforeArangoCollectionIT() throws Exception {
        collectionName = "test";
        CountDownLatch latch = new CountDownLatch(1);

        httpClient.collection(collection -> {
            collection.result().create(collectionName, res -> {
                createResponse = res.result();
                latch.countDown();
            });
        });

        latch.await();
    }

}
