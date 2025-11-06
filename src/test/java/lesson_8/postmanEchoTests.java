package lesson_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {

    private static final String BASE_URI = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        given()
                .baseUri(BASE_URI)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRequest() {
        String body = "{ \"key1\": \"value1\", \"key2\": \"value2\" }";

        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.key1", equalTo("value1"))
                .body("data.key2", equalTo("value2"));
    }

    @Test
    public void testPutRequest() {
        String body = "{ \"update\": \"true\", \"code\": 123 }";

        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.update", equalTo("true"))
                .body("data.code", equalTo(123));
    }

    @Test
    public void testPatchRequest() {
        String body = "{ \"patchField\": \"patchedValue\" }";

        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.patchField", equalTo("patchedValue"));
    }

    @Test
    public void testDeleteRequest() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "text/plain")
                .body(body)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }
}