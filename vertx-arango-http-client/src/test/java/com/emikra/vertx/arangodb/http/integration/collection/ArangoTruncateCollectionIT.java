package com.emikra.vertx.arangodb.http.integration.collection;

import com.emikra.vertx.arangodb.http.collection.data.TruncateCollectionResponse;
import org.junit.BeforeClass;

import java.util.concurrent.CountDownLatch;

public class ArangoTruncateCollectionIT extends ArangoCollectionITBase {

    private static TruncateCollectionResponse dropResponse;

    @BeforeClass
    public static void beforeArangoDropCollection() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        httpClient.collection(collection -> {
            // Create Collection "test_truncate_collection"
            collection.result().create("test_truncate_collection", res -> {

                // Create document in "test_truncate_collection"
                httpClient.document(document -> {
                    document.result().create(null, createDocRes -> {



                        collection.result().truncate("test_truncate_collection", truncateRes -> {
                            dropResponse = truncateRes.result();
                            System.out.println(dropResponse.toJson().encodePrettily());
                            latch.countDown();
                        });

                    });
                });


            });
        });

        latch.await();
    }
}
