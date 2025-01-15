package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.equalTo

@QuarkusTest
class GreetingResourceTest {
    @Test
    fun testHelloPostEndpoint() {
        given()
          .`when`().post("/hello")
          .then()
             .statusCode(200)
             .body("message", equalTo("Hello visitor, welcome to the Aurorae Project."))
    }

}