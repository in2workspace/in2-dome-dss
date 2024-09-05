package es.in2.dss.vault.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.LoginTokenAdapter;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class VaultConfig extends AbstractVaultConfiguration {

    private final VaultProperties vaultProperties;

    @NotNull
    @Override
    public VaultEndpoint vaultEndpoint() {
        log.info("VaultConfig -- vaultEndpoint() -- {}", vaultProperties.uri());
        return VaultEndpoint.from(vaultProperties.uri());
    }

    @NotNull
    @Override
    public ClientAuthentication clientAuthentication() {
        log.info("VaultConfig -- clientAuthentication() -- {}", vaultProperties.token());
        return new TokenAuthentication(vaultProperties.token());
    }

}
