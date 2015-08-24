package com.emikra.vertx.arangodb.http.integration.document;

import com.emikra.vertx.arangodb.http.document.ArangoDocumentResource;
import com.emikra.vertx.arangodb.http.integration.ArangoITBase;
import org.junit.BeforeClass;

import java.util.concurrent.CountDownLatch;

public class ArangoDocumentITBase extends ArangoITBase {

    protected static ArangoDocumentResource document;

    @BeforeClass
    public static void beforeArangoCollectionIT() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);

        httpClient.document(documentResult -> {
            document = documentResult.result();
            latch.countDown();
        });

        latch.await();
    }
}
