package admin

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.equalTo

@QuarkusTest
class AdminResourceTest {
    @Test
    fun testAdminPostEndpoint() {
        given()
          .`when`().post("/api/v1/admin")
          .then()
            .statusCode(403)
    }

}