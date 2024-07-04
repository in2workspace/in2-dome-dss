package es.in2.remotesignature.config.security;

//import es.in2.remotesignature.config.properties.AuthorizationServerProperties;
import es.in2.remotesignature.config.properties.AuthServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    private final AuthorizationServerProperties authorizationServerProperties;
//
//    @Autowired
//    public SecurityConfig(AuthorizationServerProperties authorizationServerProperties) {
//        this.authorizationServerProperties = authorizationServerProperties;
//    }
    private final AuthServerProperties authServerProperties;

    public SecurityConfig(AuthServerProperties authServerProperties) {
        this.authServerProperties = authServerProperties;
    }

//    @Bean
//    @Profile("!local")
//    public JwtDecoder jwtDecoder() {
//        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder
//                .withJwkSetUri("http://issuer-keycloak:8080/realms/CredentialIssuer/protocol/openid-connect/certs")
//                .jwsAlgorithm(SignatureAlgorithm.RS256)
//                .build();
//        jwtDecoder.setJwtValidator(JwtValidators.createDefaultWithIssuer("https://localhost:8443/realms/CredentialIssuer"));
//
//        return jwtDecoder;
//    }

    @Bean
    @Profile("!local")
    public JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder
                .withJwkSetUri(authServerProperties.internalDomain()+"/realms/"+authServerProperties.realm()+"/protocol/openid-connect/certs")
                .jwsAlgorithm(SignatureAlgorithm.RS256)
                .build();
        jwtDecoder.setJwtValidator(JwtValidators.createDefaultWithIssuer(authServerProperties.externalDomain()+"/realms/"+authServerProperties.realm()));

        return jwtDecoder;
    }

//    @Bean
//    @Profile("local")
//    public JwtDecoder jwtDecoderLocal() {
//        return JwtDecoders.fromIssuerLocation(authorizationServerProperties.getIssuerUri() + "/realms/CredentialIssuer");
//    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web
                .ignoring()
                .requestMatchers(getSwaggerPaths())
                .requestMatchers("/health");
    }

    private String[] getSwaggerPaths() {

        return new String[]{
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/api-docs/**"
        };
    }
}