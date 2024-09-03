package es.in2.dss.vault.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record Credentials(
        @NotNull String key,
        @NotNull String secret
) {
}
