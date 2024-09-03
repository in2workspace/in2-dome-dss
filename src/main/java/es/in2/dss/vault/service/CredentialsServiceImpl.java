package es.in2.dss.vault.service;

import es.in2.dss.vault.model.Credentials;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

@Service
public class CredentialsServiceImpl implements CredentialsService {

    private final VaultKeyValueOperations vaultKeyValueOperations;

    public CredentialsServiceImpl(VaultTemplate vaultTemplate) {
        this.vaultKeyValueOperations = vaultTemplate.opsForKeyValue(
                "credentials/dss",
                VaultKeyValueOperationsSupport.KeyValueBackend.KV_2);
    }

    /**
     * To secure the credentials in the vault
     *
     * @param credentials - the credentials to secure (key, value)
     */
    @Override
    public void secureCredentials(Credentials credentials) {
        vaultKeyValueOperations.put(credentials.key(), credentials);
    }

    /**
     * To retrieve the credentials from the vault
     *
     * @param key - the key to retrieve the credentials
     * @return Credentials
     */
    @Override
    public Credentials accessCredentials(String key) {
        VaultResponseSupport<Credentials> response = vaultKeyValueOperations.get(key, Credentials.class);
        assert response != null;
        return response.getData();
    }

}
