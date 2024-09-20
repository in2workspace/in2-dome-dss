package es.in2.dss.vault.adapter.azure.config;

import es.in2.dss.configuration.service.GenericConfigAdapter;
import es.in2.dss.configuration.util.ConfigAdapterFactory;
import es.in2.dss.vault.adapter.azure.config.properties.AzureKeyVaultProperties;
import es.in2.dss.vault.model.provider.VaultProviderEnum;
import es.in2.dss.vault.util.VaultProviderAnnotation;
import org.springframework.stereotype.Component;

@Component
@VaultProviderAnnotation(provider = VaultProviderEnum.AZURE)
public class AzureConfig {
    private final GenericConfigAdapter genericConfigAdapter;
    private final AzureKeyVaultProperties azureKeyVaultProperties;

    public AzureConfig(ConfigAdapterFactory configAdapterFactory, AzureKeyVaultProperties azureKeyVaultProperties){
        this.genericConfigAdapter = configAdapterFactory.getAdapter();
        this.azureKeyVaultProperties = azureKeyVaultProperties;
    }

    public String getKeyVaultUrl() {
        return genericConfigAdapter.getConfiguration(azureKeyVaultProperties.endpoint());
    }

}
