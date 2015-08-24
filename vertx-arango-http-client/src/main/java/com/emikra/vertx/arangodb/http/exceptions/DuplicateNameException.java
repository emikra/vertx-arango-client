package com.emikra.vertx.arangodb.http.exceptions;

import com.emikra.vertx.arangodb.http.ArangoResponse;

public class DuplicateNameException extends RuntimeException {

    public DuplicateNameException(ArangoResponse error) {

    }
}
