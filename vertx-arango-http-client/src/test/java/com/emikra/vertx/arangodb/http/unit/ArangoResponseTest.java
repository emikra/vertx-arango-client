package com.emikra.vertx.arangodb.http.unit;

import com.emikra.vertx.arangodb.http.ArangoResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.test.core.VertxTestBase;
import org.junit.Test;

public class ArangoResponseTest extends VertxTestBase {

    private ArangoResponse response;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        JsonObject jsonResponse = new JsonObject();
        jsonResponse.put("body", new JsonObject().put("error", true));

        response = new ArangoResponse(jsonResponse);
    }

    @Test
    public void testError() {
        assertTrue(response.isError());
        assertFalse(response.isSuccess());
    }
}
