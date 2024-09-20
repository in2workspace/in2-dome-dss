package es.in2.dss.vault.model.secret;

import lombok.Builder;

@Builder
public record KeyVaultSecret(Object value) {

}