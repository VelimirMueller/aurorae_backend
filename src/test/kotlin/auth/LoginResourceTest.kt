package auth

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import jakarta.ws.rs.core.Response
import org.hamcrest.Matchers.equalTo

@QuarkusTest
class LoginResourceTest {
    @Test
    fun testLoginEndpointWithEmptyData() {
        given()
            .contentType("application/json")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(400)
             .body("message", equalTo("Please provide data in a valid format."))
    }

    @Test
    fun testLoginEndpointWithWrongContentType() {
        given()
            .contentType("application/javascript")
            .body("{\"emailAddress\": \"xyz@qas.de\", \"password\": \"xyz123\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(415)
    }

    @Test
    fun testLoginEndpointWithoutContentType () {
        given()
        .body("{\"emailAddress\": \"xyz@qas.de\", \"password\": \"xyz123\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(415)
    }


    @Test
    fun testLoginEndpointWithIncompleteData() {
        given()
            .contentType("application/json")
            .body("{\"emailAddress\": \"xyz@qas.de\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(400)
             .body("message", equalTo("Please provide all required fields."))
    }

    @Test
    fun testLoginEndpointWithValidData() {
        given()
            .contentType("application/json")
            .body("{\"emailAddress\": \"xyz@qas.de\", \"password\": \"xyz123\"}")
          .then()
             .statusCode(200)
             .body("message", equalTo("User logged in."))
    }

    @Test
    fun testLoginEndpointWithInValidData() {
        given()
            .contentType("application/json")
            .body("{\"emailAddress\": \"xyzqweqe@qas.de\", \"password\": \"xwwqweqwyz123\"}")
          .then()
             .statusCode(400)
             .body("message", equalTo("Wrong credentials."))
    }
}