package org.wildfly.quickstarts.microprofile.config.rest;

import java.security.Principal;

import org.wildfly.security.http.oidc.AccessToken;
import org.wildfly.security.http.oidc.OidcSecurityContext;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

/**
 * Login com keycloak SSO
 */
@Path("/secured")
public class SecuredRest {

	@Context
	// Pacote jakarta.ws.rs.core
	private SecurityContext securityContext;

	@Context
	private HttpServletRequest request;

	@Inject
	private Principal principal;

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String getValue() {
		return "URL Segura";
	}

	@GET
	@Path("/username")
	@Produces(MediaType.TEXT_PLAIN)
	public String username() {
		// Jeito mais fácil do que acessar:
		// securityContext.getUserPrincipal();
		return principal.getName();
	}

	@GET
	@Path("/has-role")
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean hashole(@NotNull @QueryParam("role") String name) {
		return securityContext.isUserInRole(name);
	}

	@GET
	@Path("/access-token")
	@Produces(MediaType.APPLICATION_JSON)
	public AccessToken accessToken() {
		// Apenas para teste
		// Não retorne o token inteiro em produção
		OidcSecurityContext oidcSecurityContext = getOidcSecurityContext();
		return oidcSecurityContext.getToken();
	}

	@GET
	@Path("/id-token")
	@Produces(MediaType.TEXT_PLAIN)
	public String idToken() {
		// Apenas para teste
		// Não retorne o token inteiro em produção

		// Retornando String: can't parse JSON. Raw result:
		// RESTEASY008205: JSON Binding serialization error
		// jakarta.json.bind.JsonbException: Unable to serialize property 'address' from
		// org.wildfly.security.http.oidc.IDToken
		OidcSecurityContext oidcSecurityContext = getOidcSecurityContext();
		return oidcSecurityContext.getIDTokenString();
	}

	// TODO: Como obter o user-info?

	@GET
	@Path("/test-role")
	@Produces(MediaType.TEXT_PLAIN)
	@RolesAllowed("RES_acessorestrito")
	public String testRole() {
		return "RES_acessorestrito";
	}

	@GET
	@Path("/test-without-role")
	@RolesAllowed("NOT_EXISTS")
	@Produces(MediaType.TEXT_PLAIN)
	public void testRoleNotExists() {
		throw new RuntimeException("Não deveria chegar aqui");
	}

	private OidcSecurityContext getOidcSecurityContext() {
		return (OidcSecurityContext) request.getAttribute(OidcSecurityContext.class.getName());
	}

}
