package com.emikra.vertx.arangodb.http.integration.collection;

import com.emikra.vertx.arangodb.http.collection.data.DropCollectionResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ArangoDropCollectionIT extends ArangoCollectionITBase {

    private static DropCollectionResponse dropResponse;

    @BeforeClass
    public static void beforeArangoDropCollection() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        httpClient.collection(collection -> {
            collection.result().create("test_delete_collection", res -> {
                collection.result().drop("test_delete_collection", dropRes -> {
                    dropResponse = dropRes.result();
                    System.out.println(dropResponse.toJson().encodePrettily());
                    latch.countDown();
                });
            });
        });

        latch.await();
    }


    @Test
    public void testSuccessDeleted() {
        assertTrue(dropResponse.isSuccess());
        assertEquals(200, dropResponse.getCode().intValue());
    }


    @Test
    public void testErrorDoesNotExist() {

    }
}
