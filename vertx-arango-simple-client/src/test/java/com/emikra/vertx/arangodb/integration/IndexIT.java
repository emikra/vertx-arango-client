package com.emikra.vertx.arangodb.integration;

import com.emikra.vertx.arangodb.http.index.data.FullTextIndexResponse;
import com.emikra.vertx.arangodb.http.index.data.HashIndexResponse;
import com.emikra.vertx.arangodb.http.index.data.SkipListIndexResponse;
import com.emikra.vertx.arangodb.simple.util.ArangoUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IndexIT extends SimpleArangoClientITBase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        createTestDatabase();
        createTestCollection();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        dropTestDatabase();
    }

    @Test
    public void canCreateHashIndex() {
        testCollection().newHashIndex().on("username", "email").create(res -> {
            assertTrue(res.succeeded());

            HashIndexResponse response = res.result();
            assertEquals("hash", response.getType());
            assertEquals(false, response.getUnique());
            assertEquals(false, response.getSparse());
            assertArrayEquals(new String[]{"username", "email"}, response.getFields().toArray(new String[]{}));

            testComplete();
        });
        await();
    }

    @Test
    public void canCreateUniqueHashIndex() {
        testCollection().newHashIndex().on("username", "email").unique().create(res -> {
            assertTrue(res.succeeded());

            HashIndexResponse response = res.result();
            assertEquals("hash", response.getType());
            assertEquals(true, response.getUnique());
            assertEquals(false, response.getSparse());
            assertArrayEquals(new String[]{"username", "email"}, response.getFields().toArray(new String[]{}));

            testComplete();
        });
        await();
    }

    @Test
    public void canCreateSparseHashIndex() {
        testCollection().newHashIndex().on("username", "email").sparse().create(res -> {
            assertTrue(res.succeeded());

            HashIndexResponse response = res.result();
            assertEquals("hash", response.getType());
            assertEquals(true, response.getSparse());
            assertEquals(false, response.getUnique());
            assertArrayEquals(new String[]{"username", "email"}, response.getFields().toArray(new String[]{}));

            testComplete();
        });
        await();
    }

    @Test
    public void canCreateSkipListIndex() {
        testCollection().newSkipListIndex().on("username", "email").create(res -> {
            assertTrue(res.succeeded());

            SkipListIndexResponse response = res.result();
            assertEquals("skiplist", response.getType());
            assertEquals(false, response.getUnique());
            assertEquals(false, response.getSparse());
            assertArrayEquals(new String[]{"username", "email"}, response.getFields().toArray(new String[]{}));

            testComplete();
        });
        await();
    }

    @Test
    public void canCreateUniqueSkipListIndex() {
        testCollection().newSkipListIndex().on("username", "email").unique().create(res -> {
            assertTrue(res.succeeded());

            SkipListIndexResponse response = res.result();
            assertEquals("skiplist", response.getType());
            assertEquals(true, response.getUnique());
            assertEquals(false, response.getSparse());
            assertArrayEquals(new String[]{"username", "email"}, response.getFields().toArray(new String[]{}));

            testComplete();
        });
        await();
    }

    @Test
    public void canCreateSparseSkipListIndex() {
        testCollection().newSkipListIndex().on("username", "email").sparse().create(res -> {
            assertTrue(res.succeeded());

            SkipListIndexResponse response = res.result();
            assertEquals("skiplist", response.getType());
            assertEquals(true, response.getSparse());
            assertEquals(false, response.getUnique());
            assertArrayEquals(new String[]{"username", "email"}, response.getFields().toArray(new String[]{}));

            testComplete();
        });
        await();
    }

    @Test
    public void canCreateFullTextIndex() {
        testCollection().newFullTextIndex().on("username").minLength(3).create(res -> {
            assertTrue(res.succeeded());

            FullTextIndexResponse response = res.result();
            assertEquals("fulltext", response.getType());
            assertEquals(false, response.getUnique());
            assertEquals(true, response.getSparse());
            assertEquals(3, response.getMinLength().intValue());
            assertArrayEquals(new String[]{"username"}, response.getFields().toArray(new String[]{}));

            testComplete();
        });
        await();
    }
}