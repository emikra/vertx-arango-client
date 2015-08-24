package com.emikra.vertx.arangodb.http.document.impl;

import com.emikra.vertx.arangodb.http.ArangoHttpClientConnection;
import com.emikra.vertx.arangodb.http.document.ArangoDocumentResource;
import com.emikra.vertx.arangodb.http.document.data.*;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

public class ArangoDocumentResourceImpl implements ArangoDocumentResource {

    private ArangoHttpClientConnection conn;

    public ArangoDocumentResourceImpl(ArangoHttpClientConnection connection) {
        this.conn = connection;
    }

    @Override
    public void create(String collectionName, JsonObject document, Handler<AsyncResult<CreateDocumentResponse>> handler) {
        create(collectionName, document, null, handler);
    }

    @Override
    public void create(String collectionName, JsonObject document, Boolean createCollection, Handler<AsyncResult<CreateDocumentResponse>> handler) {

        CreateDocumentOptions options = new CreateDocumentOptions();
        options.collection = collectionName;
        options.document = document;
        options.createCollection = createCollection;

        create(options, handler);
    }

    @Override
    public void create(CreateDocumentOptions options, Handler<AsyncResult<CreateDocumentResponse>> handler) {

        this.conn.client()
                .post("/_api/document", options.document)
                .param("collection", options.collection)
                .param("createCollection", options.createCollection)
                .param("waitForSync", options.waitForSync)
                .handler(response -> handler.handle(Future.succeededFuture(new CreateDocumentResponse(response.toJson()))))
                .end();
    }

    @Override
    public void get(String documentHandle, Handler<AsyncResult<GetDocumentResponse>> handler) {

        GetDocumentOptions options = new GetDocumentOptions();
        options.documentHandle = documentHandle;

        get(options, handler);
    }

    @Override
    public void get(GetDocumentOptions options, Handler<AsyncResult<GetDocumentResponse>> handler) {

        this.conn.client()
                .get("/_api/document/:documentHandle")
                .param("documentHandle", options.documentHandle)
                .set("If-Match", options.ifMatch)
                .set("If-None-Match", options.ifNoneMatch)
                .handler(response -> handler.handle(Future.succeededFuture(new GetDocumentResponse(response.toJson()))))
                .end();
    }

    @Override
    public void getAll(String collectionName, Handler<AsyncResult<GetAllDocumentsResponse>> handler) {

        GetAllDocumentsOptions options = new GetAllDocumentsOptions();
        options.collection = collectionName;

        getAll(options, handler);
    }

    @Override
    public void getAll(GetAllDocumentsOptions options, Handler<AsyncResult<GetAllDocumentsResponse>> handler) {

        this.conn.client()
                .get("/_api/document")
                .param(options.toJson())
                .handler(response -> handler.handle(Future.succeededFuture(new GetAllDocumentsResponse(response.toJson()))))
                .end();
    }

    @Override
    public void getHeader(GetHeaderOptions options, Handler<AsyncResult<GetHeaderResponse>> handler) {

        this.conn.client()
                .head("/_api/document/:documentHandle")
                .param("documentHandle", options.documentHandle)
                .param("rev", options.rev)
                .set("If-Match", options.ifMatch)
                .set("If-None-Match", options.ifNoneMatch)
                .handler(response -> handler.handle(Future.succeededFuture(new GetHeaderResponse(response.toJson()))))
                .end();
    }

    @Override
    public void patch(PatchDocumentOptions options, Handler<AsyncResult<PatchDocumentResponse>> handler) {

        this.conn.client()
                .patch("/_api/document/:documentHandle", options.document)
                .param("documentHandle", options.documentHandle)
                .param("rev", options.rev)
                .param("waitForSync", options.waitForSync)
                .param("policy", (options.policy == null) ? null : options.policy.getValue())
                .param("keepNull", options.keepNull)
                .param("mergeObjects", options.mergeObjects)
                .set("If-Match", options.ifMatch)
                .handler(response -> handler.handle(Future.succeededFuture(new PatchDocumentResponse(response.toJson()))))
                .end();
    }

    @Override
    public void patch(String documentHandle, JsonObject document, Handler<AsyncResult<PatchDocumentResponse>> handler) {

        PatchDocumentOptions options = new PatchDocumentOptions();
        options.documentHandle = documentHandle;
        options.document = document;

        patch(options, handler);
    }

    @Override
    public void remove(RemoveDocumentOptions options, Handler<AsyncResult<RemoveDocumentResponse>> handler) {

        this.conn.client()
                .delete("/_api/document/:documentHandle")
                .param("documentHandle", options.documentHandle)
                .param("rev", options.rev)
                .param("waitForSync", options.waitForSync)
                .param("policy", (options.policy == null) ? null : options.policy.getValue())
                .set("If-Match", options.ifMatch)
                .handler(response -> handler.handle(Future.succeededFuture(new RemoveDocumentResponse(response.toJson()))))
                .end();
    }

    @Override
    public void remove(String documentHandle, Handler<AsyncResult<RemoveDocumentResponse>> handler) {

        RemoveDocumentOptions options = new RemoveDocumentOptions();
        options.documentHandle = documentHandle;

        remove(options, handler);
    }

    @Override
    public void replace(ReplaceDocumentOptions options, Handler<AsyncResult<ReplaceDocumentResponse>> handler) {

        this.conn.client()
                .put("/_api/document/:documentHandle", options.document)
                .param("documentHandle", options.documentHandle)
                .param("rev", options.rev)
                .param("waitForSync", options.waitForSync)
                .param("policy", (options.policy == null) ? null : options.policy.getValue())
                .set("If-Match", options.ifMatch)
                .handler(response -> handler.handle(Future.succeededFuture(new ReplaceDocumentResponse(response.toJson()))))
                .end();
    }

    @Override
    public void replace(String documentHandle, JsonObject document, Handler<AsyncResult<ReplaceDocumentResponse>> handler) {

        ReplaceDocumentOptions options = new ReplaceDocumentOptions();
        options.documentHandle = documentHandle;
        options.document = document;

        replace(options, handler);
    }

}
