package org.wildfly.quickstarts.microprofile.config.ejb;

import java.util.Set;

import org.wildfly.security.http.oidc.AccessToken;
import org.wildfly.security.http.oidc.OidcPrincipal;
import org.wildfly.security.http.oidc.RefreshableOidcSecurityContext;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.validation.constraints.NotNull;

@Stateless
@PermitAll
public class SecuredBean {

    @Inject
    // Pacote jakarta.security.enterprise
    private SecurityContext securityContext;

    // @Resource
    // private EJBContext ejbContext;

    // @Resource
    // private SessionContext sessionContext;

    // @Inject
    // private Principal principal;

    public String getValue() {
        return "URL Segura";
    }

    public String getUserName() {
        // Alternativas:
        // return principal.getName();
        // return ejbContext.getCallerPrincipal().getName();
        // return sessionContext.getCallerPrincipal().getName();
        return securityContext.getCallerPrincipal().getName();
    }

    public Boolean hasRole(@NotNull String name) {
        // Alternativas:
        // return ejbContext.isCallerInRole(name);
        // return sessionContext.isCallerInRole(name);
        return securityContext.isCallerInRole(name);
    }

    public AccessToken accessToken() {
        OidcPrincipal<RefreshableOidcSecurityContext> oidcPrincipal = getOidcPrincipal();
        return oidcPrincipal.getOidcSecurityContext().getToken();
    }

    public String idToken() {
        OidcPrincipal<RefreshableOidcSecurityContext> oidcPrincipal = getOidcPrincipal();
        return oidcPrincipal.getOidcSecurityContext().getIDTokenString();
    }

    @RolesAllowed("RES_acessorestrito")
    public String testRole() {
        return "RES_acessorestrito";
    }

    @RolesAllowed("NOT_EXISTS")
    public void testRoleNotExists() {
        throw new RuntimeException("Não deveria chegar aqui");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private OidcPrincipal<RefreshableOidcSecurityContext> getOidcPrincipal() {
        Set<OidcPrincipal> list = securityContext.getPrincipalsByType(OidcPrincipal.class);
        return list.stream().findFirst().orElseThrow(() -> new RuntimeException("Falha ao obter principal"));
    }

}