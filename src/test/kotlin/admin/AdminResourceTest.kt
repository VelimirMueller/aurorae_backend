package admin

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.equalTo

@QuarkusTest
class AdminResourceTest {

    @Test
    fun testAdminEndpoint() {
        given()
          .`when`().get("/admin")
          .then()
             .statusCode(403)
    }

    @Test
    fun testAdminPostEndpoint() {
        given()
          .`when`().post("/admin")
          .then()
            .statusCode(403)
    }

}