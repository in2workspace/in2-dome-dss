package es.in2.dss.api.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "certificate")
public record CertificatePassProperties(String keyStorePassword) {
}