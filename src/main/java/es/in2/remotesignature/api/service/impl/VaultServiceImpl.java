package es.in2.remotesignature.api.service.impl;

import es.in2.remotesignature.api.service.VaultService;
import es.in2.remotesignature.vault.model.secret.KeyVaultSecret;
import es.in2.remotesignature.vault.service.GenericVaultService;
import es.in2.remotesignature.vault.util.VaultFactory;
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
