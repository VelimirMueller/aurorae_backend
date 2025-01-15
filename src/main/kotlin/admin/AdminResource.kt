package admin

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.Greeting
import jakarta.annotation.security.PermitAll

@Path("/admin")
class AdminResource {

    @GET
    fun admin() = Greeting("Hello admin")

    @POST
    fun adminPost() = Greeting("Hello from admin api")
}