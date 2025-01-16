package api.auth

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.Greeting
import jakarta.annotation.security.PermitAll

@Path("/api/v1/login")
class LoginResource {
    @POST
    @PermitAll
    fun loginPost() = Greeting("Hello user, you are now logged in.")
}