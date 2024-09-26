package org.wildfly.quickstarts.microprofile.config.ejb;

import java.security.Principal;

import org.wildfly.security.http.oidc.AccessToken;

import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJBContext;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;

@Stateless
@PermitAll
public class SecuredBean {

    //@Inject
    // Pacote jakarta.security.enterprise
    //private SecurityContext context;

    @Resource
    private EJBContext ejbContext;

    @Inject
    private Principal principal;

    public String getValue() {
        return "URL Segura";
    }

    public String getUserName() {
        return principal.getName();
    }

    public Boolean hasRole(@NotNull String name) {
        // context.isCallerInRole(name);
        return ejbContext.isCallerInRole(name);
    }

    public AccessToken accessToken() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accessToken'");
    }

    public String idToken() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'idToken'");
    }

    @RolesAllowed("RES_acessorestrito")
    public String testRole() {
        return "RES_acessorestrito";
    }

    @RolesAllowed("NOT_EXISTS")
    public void testRoleNotExists() {
        throw new RuntimeException("Não deveria chegar aqui");
    }

}