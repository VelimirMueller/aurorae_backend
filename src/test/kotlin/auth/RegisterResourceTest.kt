package auth

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import jakarta.ws.rs.core.Response
import org.hamcrest.Matchers.equalTo

@QuarkusTest
class RegisterResourceTest {
    @Test
    fun testRegisterEndpointWithEmptyData() {
        given()
            .contentType("application/json")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(400)
             .body("message", equalTo("Please provide data in a valid format."))
    }

    @Test
    fun testRegisterEndpointWithWrongContentType() {
        given()
            .contentType("application/javascript")
            .body("{\"password\": \"password\", \"passwordRepeat\": \"password\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(415)
    }

    @Test
    fun testRegisterEndpointWithoutContentType () {
        given()
            .body("{\"userName\": \"username_unique\", \"password\": \"password\", \"passwordRepeat\": \"password\", \"emailAddress\": \"emai1_uniquel\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(415)
    }


    @Test
    fun testRegisterEndpointWithIncompleteData() {
        given()
            .contentType("application/json")
            .body("{\"password\": \"password\", \"passwordRepeat\": \"password\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(400)
             .body("message", equalTo("Please provide all required fields."))
    }

    @Test
    fun testRegisterEndpointWithValidDataButEmailAdressExist() {
        given()
            .contentType("application/json")
            .body("{\"userName\": \"username22\", \"password\": \"password\", \"passwordRepeat\": \"password\", \"emailAddress\": \"email\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(400)
             .body("message", equalTo("Email address already exists."))
    }

    @Test
    fun testRegisterEndpointWithValidDataButUsernameExist() {
        given()
            .contentType("application/json")
            .body("{\"userName\": \"username\", \"password\": \"password\", \"passwordRepeat\": \"password\", \"emailAddress\": \"emai12l\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(400)
             .body("message", equalTo("Username already exists."))
    }

    @Test
    fun testRegisterEndpointWithValidDataAndUniqueValues() {
        given()
            .contentType("application/json")
            .body("{\"userName\": \"username_unique\", \"password\": \"password\", \"passwordRepeat\": \"password\", \"emailAddress\": \"emai1_uniquel\"}")
          .`when`().post("/api/v1/register")
          .then()
             .statusCode(200)
             .body("message", equalTo("User registered."))
    }
}