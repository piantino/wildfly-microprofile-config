package org.wildfly.quickstarts.microprofile.config.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

/**
 * Login com keycloak SSO
 */
@Path("/secured")
public class Secured {

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getValue() {
		return "URL Segura";
	}

    @GET
	@Path("/username")
    public String sayHello(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }

}
