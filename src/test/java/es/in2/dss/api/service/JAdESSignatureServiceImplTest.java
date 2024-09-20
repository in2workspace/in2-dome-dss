package es.in2.dss.api.service;

import es.in2.dss.api.config.CertificateConfig;
import es.in2.dss.api.model.SignatureConfiguration;
import es.in2.dss.api.model.SignatureRequest;
import es.in2.dss.api.model.SignedData;
import es.in2.dss.api.model.SignatureType;
import es.in2.dss.api.service.impl.JAdESSignatureServiceImpl;
import eu.europa.esig.dss.token.Pkcs12SignatureToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class JAdESSignatureServiceImplTest {

    @Mock
    private CertificateConfig certificateConfig;

    private SignatureService signatureService;

    @BeforeEach
    public void setUp() {
        signatureService =  new JAdESSignatureServiceImpl(certificateConfig);
    }

    @Test
    void sign_ShouldReturnSignedData() {
        when(certificateConfig.loadKeyStore()).thenReturn(getPkcs12SignatureToken());
        SignatureRequest signatureRequest = SignatureRequest.builder()
                .data("SampleData")
                .configuration(SignatureConfiguration.builder()
                        .parameters(new HashMap<>())
                        .build())
                .build();
        SignedData signedData = signatureService.sign(signatureRequest);
        assertNotNull(signedData);
    }

    private Pkcs12SignatureToken getPkcs12SignatureToken() {
        try {
            String filePath = "src/test/resources/certs/test_jks.jks";
            char[] password = "1234".toCharArray();
            return new Pkcs12SignatureToken(new FileInputStream(filePath), new KeyStore.PasswordProtection(password));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getSignatureType_ShouldReturnJADES() {
        SignatureType signatureType = signatureService.getSignatureType();
        assertEquals(SignatureType.JADES, signatureType);
    }

}
