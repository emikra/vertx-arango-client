# vertx-arango-client
 
**NOTE: The API is not finalized and is still undergoing changes!**
 
This is an [ArangoDB](https://www.arangodb.com) client library built with vert.x.

## vertx-arango-http-client

This wraps the [ArangoDB HTTP API](https://docs.arangodb.com/HttpApi/index.html). It supports many (but not all) of the current APIs incuding database, indexing, document, collection, and query APIs.  

## vertx-arango-simple-client

This wraps the `vertx-arango-http-client` and provides an easier to use interface for working with ArangoDB.

## Dependencies

This project currently uses the [vertx-json-http-request](https://github.com/emikra/vertx-json-http-request) project for performing HTTP client requests. As this project is not yet in a central Maven repository, please clone that project and perform `mvn install` to install it to your local Maven repository before including this library in your project.