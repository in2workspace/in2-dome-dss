//package es.in2.remotesignature.config;
//
//import es.in2.remotesignature.config.properties.OpenApiProperties;
//import es.in2.remotesignature.services.AppConfigService;
//import es.in2.remotesignature.util.Utils;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.servers.Server;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.MDC;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//import static es.in2.remotesignature.config.azure.AppConfigurationKeys.REMOTE_SIGNATURE_BASE_URL_KEY;
//
//
//@Configuration
//@SecurityScheme(
//        name = OpenApiConfig.BEARER_AUTHENTICATION,
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "bearer"
//)
//@RequiredArgsConstructor
//@Slf4j
//public class OpenApiConfig {
//    public static final String BEARER_AUTHENTICATION = "bearer_authentication";
//
//    private final OpenApiProperties openApiProperties;
//
//    private final AppConfigService appConfigService;
//    private String openApiServerUrl;
//    @PostConstruct
//    private void initializeOpenApiServerUrl() {
//        openApiServerUrl = getOpenApiServerUrl().block();
//    }
//    private Mono<String> getOpenApiServerUrl() {
//        String processId = MDC.get(Utils.PROCESS_ID);
//        return appConfigService.getConfiguration(REMOTE_SIGNATURE_BASE_URL_KEY)
//                .doOnSuccess(value -> log.info("ProcessID: {} - Secret retrieved successfully {}", processId, value))
//                .doOnError(throwable -> log.error("ProcessID: {} - Error loading Secret: {}", processId, throwable.getMessage()));
//    }
//
//    @Bean
//    public OpenAPI openApi() {
//        return new OpenAPI()
//                .info(new Info()
//                        .contact(new Contact()
//                                .email(openApiProperties.info().contact().email())
//                                .name(openApiProperties.info().contact().name())
//                                .url(openApiProperties.info().contact().url()))
//                        .license(new License()
//                                .name(openApiProperties.info().license().name())
//                                .url(openApiProperties.info().license().url())))
//                .servers(List.of(new Server()
//                        .url(Utils.ensureUrlHasProtocol(openApiServerUrl))
//                        .description(openApiProperties.server().description())))
//                .addSecurityItem(new SecurityRequirement()
//                        .addList(BEARER_AUTHENTICATION));
//    }
//}
