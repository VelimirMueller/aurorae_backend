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

@Path("/api/v1/register")
class RegisterResource {
    private val existingEmails: List<String> = listOf("email")
    private val existingUsernames: List<String> = listOf("username")

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun registerPost(data: Map<String, Any>?): Response {
        // return early if no data is provided
        if(data == null || data.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Please provide data in a valid format."))
                .build()
        }


        val password = data["password"] as? String ?: ""
        val passwordRepeat = data["passwordRepeat"] as? String ?: ""
        val email = data["email"] as? String ?: ""
        val username = data["username"] as? String ?: ""
        
        // check if some field is empty
        if (passwordRepeat == "" || password == "" || email == "" || username == "") {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Please provide all required fields."))
                .build()
        }

        // Check if passwords match
        if (password != passwordRepeat) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Passwords do not match."))
                .build()
        }

        // check if email is unique
        if (existingEmails.contains(email)) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Email address already exists."))
                .build()
        }

        // check if username is unique
        if (existingUsernames.contains(username)) {
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(Greeting("Username already exists."))
                .build()
        }

        return Response.ok(Greeting("User registered.")).build()
    }
}