package es.in2.remotesignature.vault.adapter.azure.config;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import es.in2.remotesignature.vault.model.provider.VaultProviderEnum;
import es.in2.remotesignature.vault.util.VaultProviderAnnotation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@VaultProviderAnnotation(provider = VaultProviderEnum.AZURE)
public class AzureKeyVaultConfig {

    private final AzureConfig azureConfig;

    @Bean
    public SecretClient secretClient() {
        return new SecretClientBuilder()
                .vaultUrl(azureConfig.getKeyVaultUrl())
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

}
