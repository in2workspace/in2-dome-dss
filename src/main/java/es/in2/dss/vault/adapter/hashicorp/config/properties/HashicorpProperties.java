package es.in2.dss.vault.adapter.hashicorp.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("hashicorp.vault")
public record HashicorpProperties(String path, String host, String port, String scheme, String token) {


}
