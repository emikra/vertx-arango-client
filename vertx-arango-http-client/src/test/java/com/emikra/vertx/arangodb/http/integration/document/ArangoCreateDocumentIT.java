package com.emikra.vertx.arangodb.http.integration.document;

import com.emikra.vertx.arangodb.http.document.data.CreateDocumentOptions;
import com.emikra.vertx.arangodb.http.document.data.CreateDocumentResponse;
import com.emikra.vertx.arangodb.http.integration.ArangoITBase;
import io.vertx.core.json.JsonObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ArangoCreateDocumentIT extends ArangoITBase {

    private static CreateDocumentResponse response;

    @BeforeClass
    public static void beforeArangoDropCollection() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        httpClient.document(doc -> {

            CreateDocumentOptions options = new CreateDocumentOptions();
            options.collection = "test_create_document";
            options.createCollection = true;
            options.document = new JsonObject().put("test", true);

            doc.result().create(options, res -> {
                response = res.result();
                latch.countDown();
            });
        });

        latch.await();
    }

    @Test
    public void testCreateSuccess() {
        assertTrue(response.isSuccess());
    }
}
