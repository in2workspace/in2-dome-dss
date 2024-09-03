package es.in2.dss.vault.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("vault")
public record VaultProperties(
        @NotNull String uri,
        @NotNull String token) {
}
