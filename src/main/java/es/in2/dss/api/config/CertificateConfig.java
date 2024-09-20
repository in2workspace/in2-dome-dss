package es.in2.dss.api.config;

import es.in2.dss.api.config.properties.CertificatePassProperties;
import es.in2.dss.api.exception.LoadKeyStoreException;
import es.in2.dss.api.service.VaultService;
import es.in2.dss.vault.model.secret.KeyVaultSecret;
import eu.europa.esig.dss.token.Pkcs12SignatureToken;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Base64;

@Configuration
@RequiredArgsConstructor
public class CertificateConfig {

    private final VaultService vaultService;
    private final AppConfig appConfig;
    private final CertificatePassProperties certificatePassProperties;

    public InputStream getKeyStoreInputStream() {
        String certificateKey = appConfig.getCertificateKey();
        KeyVaultSecret secret = vaultService.getSecret(certificateKey);
        byte[] byteArray = Base64.getDecoder().decode(secret.value().toString());
        return new ByteArrayInputStream(byteArray);
    }

    public Pkcs12SignatureToken loadKeyStore() {
        Pkcs12SignatureToken token;
        try {
            token = new Pkcs12SignatureToken(getKeyStoreInputStream(), new KeyStore.PasswordProtection(certificatePassProperties.keyStorePassword().toCharArray()));
        } catch (Exception e) {
            throw new LoadKeyStoreException(e);
        }
        return token;
    }

}
