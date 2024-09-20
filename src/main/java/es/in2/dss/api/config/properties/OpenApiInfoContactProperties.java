package es.in2.dss.api.config.properties;

import jakarta.validation.constraints.NotNull;

public record OpenApiInfoContactProperties(@NotNull String email, @NotNull String name, @NotNull String url) {
}
