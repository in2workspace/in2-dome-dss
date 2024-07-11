package es.in2.remotesignature.api.service;

import es.in2.remotesignature.vault.model.secret.KeyVaultSecret;

public interface VaultService {
    KeyVaultSecret getSecret(String key);
}
