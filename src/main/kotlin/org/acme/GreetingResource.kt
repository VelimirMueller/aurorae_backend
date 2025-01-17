package org.acme

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {
    @POST
    fun helloPost() = Greeting("Hello visitor, welcome to the Aurorae Project.")
}