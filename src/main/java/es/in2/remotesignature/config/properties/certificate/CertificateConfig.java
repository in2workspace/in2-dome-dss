package es.in2.remotesignature.config.properties.certificate;

import es.in2.remotesignature.exceptions.LoadKeyStoreException;
import eu.europa.esig.dss.token.Pkcs12SignatureToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class CertificateConfig {

    private final ResourceLoader resourceLoader;
    private final CertificateProperties certificateProperties;

    public CertificateConfig(@Qualifier("webApplicationContext") ResourceLoader resourceLoader, CertificateProperties certificateProperties) {
        this.resourceLoader = resourceLoader;
        this.certificateProperties = certificateProperties;
    }

    public InputStream getKeyStoreInputStream() throws IOException {
        return resourceLoader.getResource(certificateProperties.keyStorePath()).getInputStream();
    }

    public Pkcs12SignatureToken loadKeyStore() {
        Pkcs12SignatureToken token;
        try {
            token = new Pkcs12SignatureToken(getKeyStoreInputStream(), new KeyStore.PasswordProtection(certificateProperties.keyStorePassword().toCharArray()));
        } catch (Exception e) {
            throw new LoadKeyStoreException(e);
        }
        return token;
    }

    public String getCertAlias() {
        return certificateProperties.certAlias();
    }

}
