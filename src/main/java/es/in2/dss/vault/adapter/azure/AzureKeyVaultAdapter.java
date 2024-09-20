package es.in2.dss.vault.adapter.azure;

import com.azure.security.keyvault.secrets.SecretClient;
import es.in2.dss.vault.model.provider.VaultProviderEnum;
import es.in2.dss.vault.model.secret.KeyVaultSecret;
import es.in2.dss.vault.service.GenericVaultService;
import es.in2.dss.vault.util.VaultProviderAnnotation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
@VaultProviderAnnotation(provider = VaultProviderEnum.AZURE)
public class AzureKeyVaultAdapter implements GenericVaultService {

    private final SecretClient secretClient;

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

    private String sanitazeKey(String key) {
        return key.replace(":", "-");
    }

}