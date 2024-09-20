package es.in2.dss.api.service;

import es.in2.dss.vault.model.secret.KeyVaultSecret;

public interface VaultService {
    KeyVaultSecret getSecret(String key);
}
