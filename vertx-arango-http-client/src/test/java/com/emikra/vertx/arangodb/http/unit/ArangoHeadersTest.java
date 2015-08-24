package com.emikra.vertx.arangodb.http.unit;

import com.emikra.vertx.arangodb.http.ArangoHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.test.core.VertxTestBase;
import org.junit.Test;

public class ArangoHeadersTest extends VertxTestBase {

    @Test
    public void testError() {

        JsonObject json = new JsonObject();
        json.put("CAPS", "true");

        ArangoHeaders headers = new ArangoHeaders(json);

        assertEquals(headers.get("CAPS"), "true");
        assertEquals(headers.get("caps"), "true");

    }
}

