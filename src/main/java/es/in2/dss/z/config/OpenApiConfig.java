package es.in2.dss.z.config;

import es.in2.dss.z.util.Utils;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SecurityScheme(
        name = OpenApiConfig.BEARER_AUTHENTICATION,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@RequiredArgsConstructor
@Slf4j
public class OpenApiConfig {

    public static final String BEARER_AUTHENTICATION = "bearer_authentication";
    private final AppConfig appConfig;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .contact(new Contact()
                                .email(getContactEmail())
                                .name(getContactName())
                                .url(getContactUrl()))
                        .license(new License()
                                .name(getLicenseName())
                                .url(getLicenseUrl())))
                .servers(List.of(new Server()
                        .url(getServerUrl())
                        .description(getServerDescription())))
                .addSecurityItem(new SecurityRequirement()
                        .addList(BEARER_AUTHENTICATION));
    }

    private String getServerDescription() {
        return appConfig.getServerDescription();
    }

    private String getLicenseUrl() {
        return appConfig.getLicenseUrl();
    }

    private String getLicenseName() {
        return appConfig.getLicenseName();
    }

    private String getContactUrl() {
        return appConfig.getContactUrl();
    }

    private String getContactName() {
        return appConfig.getContactName();
    }

    private String getServerUrl() {
        return Utils.ensureUrlHasProtocol(appConfig.getOpenApiServerUrl());
    }

    private String getContactEmail() {
        return appConfig.getContactEmail();
    }

}
