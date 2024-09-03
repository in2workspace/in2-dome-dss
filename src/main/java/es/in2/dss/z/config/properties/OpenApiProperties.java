package es.in2.dss.z.config.properties;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.Optional;

/**
 * Configuration intended to be used by the OpenAPI documentation.
 *
 * @param server - server information
 * @param info   - organization information
 */
@Slf4j
public record OpenApiProperties(@NestedConfigurationProperty OpenApiServerProperties server,
                                @NestedConfigurationProperty OpenApiInfoProperties info) {

    @ConstructorBinding
    public OpenApiProperties(OpenApiServerProperties server, OpenApiInfoProperties info) {
        log.info("OpenApiProperties constructor called");
        this.server = Optional.ofNullable(server).orElse(new OpenApiServerProperties(null, null));
        log.info("Server: {}", this.server);
        this.info = Optional.ofNullable(info).orElse(new OpenApiInfoProperties(null, null, null, null, null, null));
    }

}

