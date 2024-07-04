package es.in2.remotesignature.services;

import es.in2.remotesignature.config.properties.certificate.CertificateConfig;
import es.in2.remotesignature.config.properties.certificate.CertificateProperties;
import es.in2.remotesignature.dtos.SignatureConfiguration;
import es.in2.remotesignature.dtos.SignatureRequest;
import es.in2.remotesignature.dtos.SignedData;
import es.in2.remotesignature.enums.SignatureType;
import es.in2.remotesignature.services.configuration.ServiceTestConfiguration;
import es.in2.remotesignature.services.impl.JAdESSignatureServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = ServiceTestConfiguration.class)
@EnableConfigurationProperties(value = { CertificateProperties.class })
class JAdESSignatureServiceImplTest {

    // The actual implementation is loaded due to the complexity of creating the unit test because of the dependency eu.europa.esig.dss,
    // but the test still go through almost all our code and the coverage is 88%
    @Autowired
    private CertificateConfig certificateConfig;

    private SignatureService signatureService;

    @BeforeEach
    public void setUp() {
        signatureService =  new JAdESSignatureServiceImpl(certificateConfig);
    }

    @Test
    void sign_ShouldReturnSignedData() {
        SignatureRequest signatureRequest = new SignatureRequest();
        signatureRequest.setData("SampleData");

        SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
        signatureConfiguration.setParameters(new HashMap<>());
        signatureRequest.setConfiguration(signatureConfiguration);

        SignedData signedData = signatureService.sign(signatureRequest);

        assertNotNull(signedData);
    }

    @Test
    void getSignatureType_ShouldReturnJADES() {
        SignatureType signatureType = signatureService.getSignatureType();
        assertEquals(SignatureType.JADES, signatureType);
    }

}
