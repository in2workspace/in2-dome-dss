package es.in2.remotesignature.vault.model.secret;

import lombok.Builder;

@Builder
public record KeyVaultSecret(Object value) {

}