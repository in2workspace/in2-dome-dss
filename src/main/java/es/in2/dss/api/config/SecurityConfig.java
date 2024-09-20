package es.in2.dss.api.config;

import es.in2.dss.api.config.properties.AuthServerProperties;
import es.in2.dss.api.util.Utils;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class SecurityConfig {

    private final AppConfig appConfig;
    private final AuthServerProperties authServerProperties;

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

    @Bean
    @Profile("local")
    public JwtDecoder jwtDecoderLocal() {
        return JwtDecoders.fromIssuerLocation(getIssuerUri() + "/realms/EAAProvider");
    }

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

    private String getIssuerUri() {
        return Utils.ensureUrlHasProtocol(appConfig.getIssuerUri());
    }

}
