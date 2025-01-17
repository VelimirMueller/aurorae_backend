package api.auth

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.Consumes
import org.acme.Greeting
import jakarta.annotation.security.PermitAll

@Path("/api/v1/login")
class LoginResource {
    private val existingUsers: Map<String, String> = mapOf(
        "email@example.com" to "password123",
        "xyz@qas.de" to "xyz123"
    )

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun loginPost (data: Map<String, Any>?): Response {
        // return early if no data is provided
        if(data == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Please provide data in a valid format."))
                .build()
        }

        val password = data["password"] as? String ?: ""
        val email = data["emailAddress"] as? String ?: ""
        
        // check if some field is empty
        if (password.isEmpty() || email.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Please provide all required fields."))
                .build()
        }

        // check if email password combination is correct
        if (existingUsers[email] != password) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Wrong credentials."))
                .build()
        }

        return Response.ok(Greeting("User logged in.")).build()
    }
}