package com.emikra.vertx.arangodb.http.integration.document;

import com.emikra.vertx.arangodb.http.document.data.CreateDocumentOptions;
import com.emikra.vertx.arangodb.http.document.data.GetDocumentResponse;
import io.vertx.core.json.JsonObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ArangoGetDocumentIT extends ArangoDocumentITBase {

    private static GetDocumentResponse response;

    @BeforeClass
    public static void beforeGetDocumentIT() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        CreateDocumentOptions create = new CreateDocumentOptions();
        create.collection = "test_get_document";
        create.createCollection = true;
        create.document = new JsonObject()
                .put("a", 1)
                .put("b", "two")
                .put("c", true);

        document.create(create, createResponse -> {
            document.get(createResponse.result().getId(), getResponse -> {
                response = getResponse.result();
                latch.countDown();
            });
        });

        latch.await();
    }

    @Test
    public void testGetResponseSuccess() {
        System.out.println(response.toJson().encodePrettily());
        assertTrue(response.isSuccess());
    }


}
