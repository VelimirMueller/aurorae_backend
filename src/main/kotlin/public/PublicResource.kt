package public

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.Greeting
import jakarta.annotation.security.PermitAll

@Path("/public")
class PublicResource {

    @GET
    fun hello() = Greeting("Hello visitor, welcome to the aurorae world!")

    @POST
    fun helloPost() = Greeting("Hello visitor, welcome to the aurorae world! - post api")
}