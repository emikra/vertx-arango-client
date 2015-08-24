package com.emikra.vertx.arangodb.http.unit;

import com.emikra.vertx.arangodb.http.ArangoHttpClientOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.test.core.VertxTestBase;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArangoHttpClientOptionsTest extends VertxTestBase {

    private static ArangoHttpClientOptions pojo;
    private static JsonObject json;

    private static String HOST_KEY     = "host";
    private static String PORT_KEY     = "port";
    private static String DATABASE_KEY = "database";
    private static String USERNAME_KEY = "username";
    private static String PASSWORD_KEY = "password";

    private static String HOST         = "127.0.0.1";
    private static String DATABASE     = "theDatabase";
    private static String USERNAME     = "arango_user";
    private static String PASSWORD     = "arango_password";
    private static Integer PORT        = 8530;

    @BeforeClass
    public static void setup() {

        JsonObject json = new JsonObject();
        json.put(HOST_KEY, HOST);
        json.put(PORT_KEY, PORT);
        json.put(DATABASE_KEY, DATABASE);
        json.put(USERNAME_KEY, USERNAME);
        json.put(PASSWORD_KEY, PASSWORD);

        pojo = new ArangoHttpClientOptions(json);

        ArangoHttpClientOptions options = new ArangoHttpClientOptions();
        options.setHost(HOST);
        options.setPort(PORT);
        options.setDatabase(DATABASE);
        options.setUsername(USERNAME);
        options.setPassword(PASSWORD);

        ArangoHttpClientOptionsTest.json = options.toJson();
    }

    @Test
    public void testPojoHost() {
        assertEquals(pojo.getHost(), HOST);
    }

    @Test
    public void testPojoPort() {
        assertEquals(pojo.getPort(), PORT);
    }

    @Test
    public void testPojoaDatabase() {
        assertEquals(pojo.getDatabase(), DATABASE);
    }

    @Test
    public void testPojoUsername() {
        assertEquals(pojo.getUsername(), USERNAME);
    }

    @Test
    public void testPojoPassword() {
        assertEquals(pojo.getPassword(), PASSWORD);
    }

    @Test
    public void testJsonHost() {
        assertEquals(json.getString(HOST_KEY), HOST);
    }

    @Test
    public void testJsonPort() {
        assertEquals(json.getInteger(PORT_KEY), PORT);
    }

    @Test
    public void testJsonDatabase() {
        assertEquals(json.getString(DATABASE_KEY), DATABASE);
    }

    @Test
    public void testJsonUsername() {
        assertEquals(json.getString(USERNAME_KEY), USERNAME);
    }

    @Test
    public void testJsonPassword() {
        assertEquals(json.getString(PASSWORD_KEY), PASSWORD);
    }

}
