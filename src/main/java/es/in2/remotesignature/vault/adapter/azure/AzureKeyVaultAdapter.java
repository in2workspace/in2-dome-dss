package es.in2.remotesignature.vault.adapter.azure;

import com.azure.security.keyvault.secrets.SecretClient;
import es.in2.remotesignature.vault.model.provider.VaultProviderEnum;
import es.in2.remotesignature.vault.model.secret.KeyVaultSecret;
import es.in2.remotesignature.vault.service.GenericVaultService;
import es.in2.remotesignature.vault.util.VaultProviderAnnotation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@Slf4j
@RequiredArgsConstructor
@VaultProviderAnnotation(provider = VaultProviderEnum.AZURE)
public class AzureKeyVaultAdapter implements GenericVaultService {
    private final SecretClient secretClient;

    @Override
    public Mono<Void> saveSecret(String key, KeyVaultSecret secret) {
        return Mono.fromCallable(() -> secretClient.setSecret(sanitazeKey(key), secret.value().toString()))
                .then()
                .doOnSuccess(voidValue -> log.info("Secret saved successfully"))
                .onErrorResume(Exception.class, e -> Mono.error(new RuntimeException("Error saving secret in Azure Key Vault", e)));
    }

    @Override
    public Mono<KeyVaultSecret> getSecret(String key) {
        return Mono.fromCallable(() -> {
                    com.azure.security.keyvault.secrets.models.KeyVaultSecret secret = secretClient.getSecret(sanitazeKey(key));

                    return KeyVaultSecret.builder()
                            .value(secret.getValue())
                            .build();
                })
                .doOnSuccess(voidValue -> log.info("Secret retrieved successfully"))
                .onErrorResume(Exception.class, Mono::error);
    }

    @Override
    public Mono<Void> deleteSecret(String key) {
        return Mono.fromRunnable(() -> {
                    try {
                        secretClient.beginDeleteSecret(sanitazeKey(key));
                    } catch (Exception e) {
                        log.error("Failed to delete secret: {}", e.getMessage());
                    }
                })
                .then()
                .doOnSuccess(voidValue -> log.info("Secret deleted successfully"))
                .onErrorResume(Exception.class, Mono::error);
    }

    private String sanitazeKey(String key) {
        return key.replace(":", "-");
    }

}