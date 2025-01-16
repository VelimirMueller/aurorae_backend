package api.auth

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.acme.Greeting
import jakarta.annotation.security.PermitAll
import jakarta.annotation.security.RolesAllowed

@Path("/api/v1/register")
class RegisterResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun registerPost(data: Map<String, Any>): Response {
        // Check if passwords match
        if (data.get("password") != data.get("passwordRepeat")) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Passwords do not match."))
                .build()
        }

        return Response.ok(Greeting("Hello user, we recceived following data: $data for the register endpoint")).build()
    }
}