package com.emikra.vertx.arangodb.http.integration.collection;

import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionResponse;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ArangoCreateCollectionIT extends ArangoCollectionITBase {


    @AfterClass
    public static void afterArangoCollectionIT() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        httpClient.collection(collection -> {
            collection.result().drop(collectionName, res -> {
                latch.countDown();
            });
        });

        latch.await();
    }

    @Test
    public void testDuplicateError() {

        httpClient.collection(collection -> {
            collection.result().create(collectionName, res -> {
                CreateCollectionResponse errResponse = res.result();

                assertTrue(errResponse.isError());
                assertNotNull(errResponse.error);
                assertEquals(409, errResponse.getCode().intValue());
                assertEquals(1207, errResponse.error.errorNum.intValue());

                testComplete();
            });
        });

        await();
    }

    @Test
    public void testSuccessCreated() {
        assertEquals(200, createResponse.getCode().intValue());
    }

}
