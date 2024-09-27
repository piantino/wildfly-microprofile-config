package org.wildfly.quickstarts.microprofile.config.rest;

import org.wildfly.quickstarts.microprofile.config.ejb.SecuredBean;
import org.wildfly.security.http.oidc.AccessToken;

import jakarta.ejb.EJB;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/secured-ejb")
public class SecuredEjbRest {

    @EJB
    private SecuredBean securedBean;

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getValue() {
		return securedBean.getValue();
	}

	@GET
	@Path("/username")
	@Produces(MediaType.TEXT_PLAIN)
	public String username() {
		return securedBean.getUserName();
	}

	@GET
	@Path("/has-role")
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean hashole(@NotNull @QueryParam("role") String name) {
		return securedBean.hasRole(name);
	}

	@GET
	@Path("/access-token")
	@Produces(MediaType.APPLICATION_JSON)
	public AccessToken accessToken() {
		return securedBean.accessToken();
	}

	@GET
	@Path("/id-token")
	@Produces(MediaType.TEXT_PLAIN)
	public String idToken() {
		return securedBean.idToken();
	}

	@GET
	@Path("/test-role")
	@Produces(MediaType.TEXT_PLAIN)
	public String testRole() {
		return securedBean.testRole();
	}

	@GET
	@Path("/test-without-role")
	@Produces(MediaType.TEXT_PLAIN)
	public void testRoleNotExists() {
		securedBean.testRoleNotExists();
	}
}
