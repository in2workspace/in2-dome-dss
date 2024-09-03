package es.in2.dss.z.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.Optional;

@ConfigurationProperties(prefix = "app.properties")
public record AppProperties(
        @NestedConfigurationProperty OpenApiProperties openApi,
        @NestedConfigurationProperty AuthorizationServerProperties authorizationServer,
        @NestedConfigurationProperty CertificateProperties certificate
) {

    @ConstructorBinding
    public AppProperties(OpenApiProperties openApi, AuthorizationServerProperties authorizationServer, CertificateProperties certificate) {
        this.openApi = Optional.ofNullable(openApi).orElse(new OpenApiProperties(null, null));
        this.authorizationServer = Optional.ofNullable(authorizationServer).orElse(new AuthorizationServerProperties(null, null));
        this.certificate = Optional.ofNullable(certificate).orElse(new CertificateProperties(null));
    }

}
