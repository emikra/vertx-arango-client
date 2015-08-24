package com.emikra.vertx.arangodb.http.integration;

import com.emikra.vertx.arangodb.http.collection.data.CollectionType;
import com.emikra.vertx.arangodb.http.collection.data.CreateCollectionOptions;
import org.junit.Test;

public class ArangoIT extends ArangoITBase {

    @Test
    public void testCreateCollectionOptions() {

        CreateCollectionOptions options = new CreateCollectionOptions();
        options.name = "test";
        options.type = CollectionType.EDGE;

        System.out.println(options.toJson().encodePrettily());

        testComplete();

    }

    @Test
    public void testArangoClientCreateCollection() {
        httpClient.collection(onSuccess(collection -> {

            collection.create("test", onSuccess(response -> {
                System.out.println(response.toJson().encodePrettily());
                testComplete();
            }));
        }));

        await();

    }
}
