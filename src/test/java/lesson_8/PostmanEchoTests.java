package lesson_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
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
                .body("args.foo2", equalTo("bar2"))
                .body("url", containsString("/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawText() {
        String rawBody = "This is expected to be sent back as part of response body.";
        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "text/plain")
                .body(rawBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawBody));
    }

    @Test
    public void testPostFormData() {
        given()
                .baseUri(BASE_URI)
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    public void testPutRequest() {
        String rawBody = "This is expected to be sent back as part of response body.";
        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "text/plain")
                .body(rawBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawBody));
    }

    @Test
    public void testPatchRequest() {
        String rawBody = "This is expected to be sent back as part of response body.";
        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "text/plain")
                .body(rawBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawBody));
    }

    @Test
    public void testDeleteRequest() {
        String rawBody = "This is expected to be sent back as part of response body.";
        given()
                .baseUri(BASE_URI)
                .header("Content-Type", "text/plain")
                .body(rawBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(rawBody));
    }
}