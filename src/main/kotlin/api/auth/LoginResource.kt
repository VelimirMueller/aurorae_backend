package api.auth

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.Greeting
import jakarta.annotation.security.PermitAll
import jakarta.annotation.security.RolesAllowed

@Path("/api/v1/login")
class LoginResource {
    @POST
    fun loginPost() = Greeting("Hello user, you are now logged in.")
}