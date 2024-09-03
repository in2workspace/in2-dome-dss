package es.in2.dss.z.config.properties;

import jakarta.validation.constraints.NotNull;

public record OpenApiInfoContactProperties(@NotNull String email, @NotNull String name, @NotNull String url) {
}
