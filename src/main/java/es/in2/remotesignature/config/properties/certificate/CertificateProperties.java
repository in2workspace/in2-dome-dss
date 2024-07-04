package es.in2.remotesignature.config.properties.certificate;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "certificate")
public record CertificateProperties(String keyStorePath, String keyStorePassword, String keyStoreType, String certAlias,
                                    String privateKeyPassword) {
}