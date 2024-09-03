package es.in2.dss.z.service;

import es.in2.dss.model.VaultSecret;

public interface VaultService {
    VaultSecret getSecret(String key);
}
