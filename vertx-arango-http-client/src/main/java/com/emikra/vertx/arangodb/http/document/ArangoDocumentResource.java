package com.emikra.vertx.arangodb.http.document;

import com.emikra.vertx.arangodb.http.document.data.*;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

@VertxGen
public interface ArangoDocumentResource {

    void create(String collectionName, JsonObject document, Handler<AsyncResult<CreateDocumentResponse>> handler);

    void create(String collectionName, JsonObject document, Boolean createCollection, Handler<AsyncResult<CreateDocumentResponse>> handler);

    void create(CreateDocumentOptions options, Handler<AsyncResult<CreateDocumentResponse>> handler);

    void get(String documentHandle, Handler<AsyncResult<GetDocumentResponse>> handler);

    void get(GetDocumentOptions options, Handler<AsyncResult<GetDocumentResponse>> handler);

    void getAll(String collectionName, Handler<AsyncResult<GetAllDocumentsResponse>> handler);

    void getAll(GetAllDocumentsOptions options, Handler<AsyncResult<GetAllDocumentsResponse>> handler);

    void getHeader(GetHeaderOptions options, Handler<AsyncResult<GetHeaderResponse>> handler);

    void patch(PatchDocumentOptions options, Handler<AsyncResult<PatchDocumentResponse>> handler);

    void patch(String documentHandle, JsonObject document, Handler<AsyncResult<PatchDocumentResponse>> handler);

    void remove(RemoveDocumentOptions options, Handler<AsyncResult<RemoveDocumentResponse>> handler);

    void remove(String documentHandle, Handler<AsyncResult<RemoveDocumentResponse>> handler);

    void replace(ReplaceDocumentOptions options, Handler<AsyncResult<ReplaceDocumentResponse>> handler);

    void replace(String documentHandle, JsonObject document, Handler<AsyncResult<ReplaceDocumentResponse>> handler);

}
