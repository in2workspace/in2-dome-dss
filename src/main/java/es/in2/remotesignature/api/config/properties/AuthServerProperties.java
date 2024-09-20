package es.in2.remotesignature.api.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auth-server")
public record AuthServerProperties(String internalDomain, String externalDomain, String realm) {
}
