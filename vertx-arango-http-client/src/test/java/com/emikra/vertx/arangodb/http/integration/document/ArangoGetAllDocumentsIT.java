package com.emikra.vertx.arangodb.http.integration.document;

import com.emikra.vertx.arangodb.http.document.data.CreateDocumentOptions;
import com.emikra.vertx.arangodb.http.document.data.GetAllDocumentsResponse;
import io.vertx.core.json.JsonObject;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ArangoGetAllDocumentsIT extends ArangoDocumentITBase {

    private static GetAllDocumentsResponse response;

    @BeforeClass
    public static void beforeGetDocumentIT() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        CreateDocumentOptions create = new CreateDocumentOptions();
        create.collection = "test_GetAllDocuments";
        create.createCollection = true;
        create.document = new JsonObject()
                .put("a", 1)
                .put("b", "two")
                .put("c", true);

        document.create(create, createResponse -> {
            document.create(create, cr2 -> {
                document.create(create, cr3 -> {
                    document.getAll("test_GetAllDocuments", getResponse -> {
                        response = getResponse.result();
                        latch.countDown();
                    });
                });
            });
        });

        latch.await();
    }

    @Test
    public void testResponseSuccess() {
        System.out.println(response.toJson().encodePrettily());
    }
}
