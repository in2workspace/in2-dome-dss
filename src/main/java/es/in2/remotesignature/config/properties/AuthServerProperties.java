package es.in2.remotesignature.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "auth-server")
public record AuthServerProperties(String internalDomain, String externalDomain, String realm) {
}