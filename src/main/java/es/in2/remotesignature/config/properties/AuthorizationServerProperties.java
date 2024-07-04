//package es.in2.remotesignature.config.properties;
//
//import es.in2.remotesignature.services.AppConfigService;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import static es.in2.remotesignature.config.azure.AppConfigurationKeys.KEYCLOAK_URI_KEY;
//
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class AuthorizationServerProperties {
//
//    private final AppConfigService appConfigService;
//
//    private String issuerUri;
//
//    @PostConstruct
//    public void initializeAuthorizationServerProperties() {
//        this.issuerUri = getIssuerUri();
//    }
//
//    public String getIssuerUri() {
//        if (issuerUri == null) {
//            issuerUri = appConfigService.getConfiguration(KEYCLOAK_URI_KEY)
//                    .doOnSuccess(value -> log.info("Issuer URI retrieved successfully: {}", value))
//                    .doOnError(throwable -> log.error("Error loading Issuer URI: {}", throwable.getMessage()))
//                    .block();
//        }
//
//        return issuerUri;
//    }
//}
