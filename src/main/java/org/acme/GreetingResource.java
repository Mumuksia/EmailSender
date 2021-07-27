package org.acme;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/email")
public class GreetingResource {

    @Inject
    Mailer mailer;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("/send")
    public Response sendASimpleEmail(@PathParam("body") String body, @PathParam("to") String to) {
        mailer.send(Mail.withText(to, "A simple email from quarkus", body));
        return Response.accepted().build();
    }
}