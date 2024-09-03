package es.in2.dss.z.service.impl;

import es.in2.dss.z.service.VaultService;
import es.in2.dss.model.VaultSecret;
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
    public VaultSecret getSecret(String key) {
        return genericVaultService.getSecret(key).block();
    }

}
