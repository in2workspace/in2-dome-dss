package es.in2.dss.api.service.impl;

import es.in2.dss.api.service.VaultService;
import es.in2.dss.vault.model.secret.KeyVaultSecret;
import es.in2.dss.vault.service.GenericVaultService;
import es.in2.dss.vault.util.VaultFactory;
import org.springframework.stereotype.Service;

@Service
public class VaultServiceImpl implements VaultService {

    private final GenericVaultService genericVaultService;

    public VaultServiceImpl(VaultFactory vaultFactory) {
        this.genericVaultService = vaultFactory.getVaultService();
    }

    @Override
    public KeyVaultSecret getSecret(String key) {
        return genericVaultService.getSecret(key).block();
    }

}
