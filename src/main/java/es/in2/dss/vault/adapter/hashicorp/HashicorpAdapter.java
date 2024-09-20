package es.in2.dss.vault.adapter.hashicorp;

import es.in2.dss.vault.adapter.hashicorp.config.HashicorpConfig;
import es.in2.dss.vault.adapter.hashicorp.model.HashicorpSecretResponse;
import es.in2.dss.vault.model.provider.VaultProviderEnum;
import es.in2.dss.vault.model.secret.KeyVaultSecret;
import es.in2.dss.vault.service.GenericVaultService;
import es.in2.dss.vault.util.VaultProviderAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.ReactiveVaultOperations;
import org.springframework.vault.core.SecretNotFoundException;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Service
@VaultProviderAnnotation(provider = VaultProviderEnum.HASHICORP)
public class HashicorpAdapter implements GenericVaultService {

    public static final String DATA = "/data/";
    public static final String METADATA = "/metadata/";
    private final ReactiveVaultOperations vaultOperations;
    private final String hashicorpSecretPath;

    public HashicorpAdapter(ReactiveVaultOperations vaultOperations, HashicorpConfig hashicorpConfig) {
        this.vaultOperations = vaultOperations;
        this.hashicorpSecretPath = hashicorpConfig.getSecretPath();
    }

    @Override
    public Mono<KeyVaultSecret> getSecret(String key) {
        return vaultOperations.read(hashicorpSecretPath + DATA + key)
                .flatMap(response -> {
                    HashicorpSecretResponse hashicorpSecretResponse;
                    try {
                        hashicorpSecretResponse = new HashicorpSecretResponse(Objects.requireNonNull(response.getData()));
                    } catch (Exception e) {
                        return Mono.error(new RuntimeException("Vault response could not be parsed"));
                    }
                    if (hashicorpSecretResponse.data() == null || hashicorpSecretResponse.data().isEmpty() || hashicorpSecretResponse.data().get(key) == null) {
                        return Mono.error(new SecretNotFoundException("Secret not found: " + key, key));
                    }
                    KeyVaultSecret keyVaultSecret = new KeyVaultSecret(hashicorpSecretResponse.data().get(key));
                    return Mono.just(keyVaultSecret);
                })
                .doOnSuccess(secret -> log.debug("Secret retrieved successfully"))
                .doOnError(error -> log.error("Error retrieving secret: " + key, error.getMessage(), error))
                .onErrorResume(Exception.class, Mono::error);
    }

}
