package es.in2.remotesignature.api.config.properties;

import jakarta.validation.constraints.NotNull;

public record OpenApiInfoContactProperties(@NotNull String email, @NotNull String name, @NotNull String url) {
}
