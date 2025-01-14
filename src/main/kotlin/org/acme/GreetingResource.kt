package org.acme

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.acme.Greeting

@Path("/hello")
class GreetingResource {

    @GET
    fun hello() = Greeting("Hello visitor, welcome to the aurorae world!")
}