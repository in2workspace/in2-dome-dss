package es.in2.dss.vault.service;

import es.in2.dss.vault.model.secret.KeyVaultSecret;
import reactor.core.publisher.Mono;

public interface GenericVaultService {
    Mono<KeyVaultSecret> getSecret(String key);
}
