package com.emikra.vertx.arangodb.http.integration.query;

import com.emikra.vertx.arangodb.http.integration.ArangoITBase;
import com.emikra.vertx.arangodb.http.query.simple.data.ByExampleOptions;
import org.junit.Test;

public class ArangoQueryIT extends ArangoITBase {


    @Test
    public void testQuery() {

        httpClient.simpleQuery(sq -> {
            ByExampleOptions options = new ByExampleOptions();
            options.batchSize = 8;
            sq.result().byExample(options, re -> {
                re.result().getDocuments().forEach(document -> {
                    System.out.println(document.getId());
                });
            });
        });
    }
}
