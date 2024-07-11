package es.in2.remotesignature.api.service;

import es.in2.remotesignature.api.model.SignatureConfiguration;
import es.in2.remotesignature.api.model.SignatureRequest;
import es.in2.remotesignature.api.model.SignedData;
import es.in2.remotesignature.api.model.SignatureType;
import es.in2.remotesignature.api.exception.SignedDataException;
import es.in2.remotesignature.api.service.impl.CoseSignatureServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoseSignatureServiceImplTest {
    private SignatureService signatureService;
    @BeforeEach
    public void setUp() {
        signatureService = new CoseSignatureServiceImpl();
    }

    @Test
    void sign_ShouldReturnSignedData() {
        SignatureRequest signatureRequest = SignatureRequest.builder()
                .data("SampleData")
                .configuration(SignatureConfiguration.builder()
                        .parameters(null)
                        .build())
                .build();
        SignedData signedData = signatureService.sign(signatureRequest);
        assertNotNull(signedData);
    }

    @Test
    void sign_ShouldReturnSignedDataException_whenSignatureRequestIsNull() {
        assertThrows(SignedDataException.class, () -> signatureService.sign(null));
    }

    @Test
    void getSignatureType_ShouldReturnCOSE() {
        SignatureType signatureType = signatureService.getSignatureType();
        assertEquals(SignatureType.COSE, signatureType);
    }
}
