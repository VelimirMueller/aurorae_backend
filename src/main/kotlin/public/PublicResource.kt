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
    fun public() = Greeting("Hello visitor, welcome to the aurorae world!")

    @POST
    fun publicPost() = Greeting("Hello visitor, welcome to the aurorae world from public post api")
}