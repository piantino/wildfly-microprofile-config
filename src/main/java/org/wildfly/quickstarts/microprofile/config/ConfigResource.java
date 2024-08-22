package org.wildfly.quickstarts.microprofile.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/config")
@ApplicationScoped
public class ConfigResource {

	@Inject
	@ConfigProperty(name = "config.prop")
	private String configValue;

	@GET
	@Path("/value")
	public String getValue() {
		return configValue;
	}
}