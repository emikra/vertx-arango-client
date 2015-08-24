package com.emikra.vertx.arangodb.http.integration;

import com.emikra.vertx.arangodb.http.ArangoHttpClient;
import com.emikra.vertx.arangodb.http.ArangoHttpClientOptions;
import io.vertx.core.Vertx;
import io.vertx.test.core.VertxTestBase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.util.concurrent.CountDownLatch;

public class ArangoITBase extends VertxTestBase {

    protected static ArangoHttpClient httpClient;
    protected static String databaseName;

    @Rule
    public TestName name = new TestName();

    @BeforeClass
    public static void beforeClass() throws Exception {

        databaseName = "test_vertx_arangodb";

        CountDownLatch latch = new CountDownLatch(1);

        ArangoHttpClientOptions options = new ArangoHttpClientOptions();
        options.setHost("192.168.59.103").setPort(8530);
        options.setUsername("root");//.setPassword("KmFO44knGUOhA3yk");
        options.setDatabase(databaseName);

        httpClient = ArangoHttpClient.create(Vertx.vertx(), options);

        httpClient.database(db -> {

            db.result().create(databaseName, createResponse -> {
                System.out.println("ArangoITBase:beforeClass() -- creating database");
                System.out.println(createResponse.result().toJson().encodePrettily());
                System.out.println("----");
                latch.countDown();
            });
        });

        latch.await();
    }

    @AfterClass
    public static void afterClass() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);

        httpClient.database(db -> {
            db.result().drop(databaseName, dropResponse -> {
                System.out.println("ArangoITBase:afterClass() -- deleting database");
                System.out.println(dropResponse.result().toJson().encodePrettily());
                System.out.println("----");
                latch.countDown();
            });
        });

        latch.await();
    }

}
