package admin

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.Greeting
import jakarta.annotation.security.RolesAllowed

@Path("/api/v1/admin")
class AdminResource {

    @POST
    @RolesAllowed("admin")
    fun adminPost() = Greeting("Hello from admin api")
}

