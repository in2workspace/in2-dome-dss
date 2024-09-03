package es.in2.dss.vault.config;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
@RequiredArgsConstructor
public class VaultConfig extends AbstractVaultConfiguration {

    private final VaultProperties vaultProperties;

    @NotNull
    @Override
    public VaultEndpoint vaultEndpoint() {
        return VaultEndpoint.from(vaultProperties.uri());
    }

    @NotNull
    @Override
    public ClientAuthentication clientAuthentication() {
        return new TokenAuthentication(vaultProperties.token());
    }

}
