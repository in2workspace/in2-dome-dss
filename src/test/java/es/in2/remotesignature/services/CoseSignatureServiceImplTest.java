package es.in2.remotesignature.services;

import es.in2.remotesignature.dtos.SignatureConfiguration;
import es.in2.remotesignature.dtos.SignatureRequest;
import es.in2.remotesignature.dtos.SignedData;
import es.in2.remotesignature.enums.SignatureType;
import es.in2.remotesignature.exceptions.SignedDataException;
import es.in2.remotesignature.services.impl.CoseSignatureServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.Exceptions;

import static org.junit.jupiter.api.Assertions.*;

class CoseSignatureServiceImplTest {
    private SignatureService signatureService;
    @BeforeEach
    public void setUp() {
        signatureService = new CoseSignatureServiceImpl();
    }

    @Test
    void sign_ShouldReturnSignedData() {
        SignatureRequest signatureRequest = new SignatureRequest();
        signatureRequest.setData("SampleData");

        SignatureConfiguration signatureConfiguration = new SignatureConfiguration();
        signatureConfiguration.setParameters(null);
        signatureRequest.setConfiguration(signatureConfiguration);

        SignedData signedData = signatureService.sign(signatureRequest);

        assertNotNull(signedData);
    }

    @Test
    void sign_ShouldReturnSignedDataException_whenSignatureRequestIsNull() {
        assertThrows(SignedDataException.class, () -> {
            try {
                signatureService.sign(null);
            } catch (Exception e) {
                throw Exceptions.unwrap(e);
            }
        });
    }

    @Test
    void getSignatureType_ShouldReturnCOSE() {
        SignatureType signatureType = signatureService.getSignatureType();
        assertEquals(SignatureType.COSE, signatureType);
    }
}
