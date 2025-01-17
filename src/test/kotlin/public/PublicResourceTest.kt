package public

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.equalTo

@QuarkusTest
class PublicResourceTest {

    @Test
    fun testPublicPostEndpoint() {
        given()
          .`when`().post("/api/v1/public")
          .then()
             .statusCode(403)
    }

}
