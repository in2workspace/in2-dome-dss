package es.in2.remotesignature.services;

import es.in2.remotesignature.enums.SignatureType;
import es.in2.remotesignature.exceptions.SignatureTypeNotSupportedException;
import es.in2.remotesignature.services.impl.SignatureServiceFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SignatureServiceFactoryImplTest {
    @InjectMocks
    private SignatureServiceFactoryImpl signatureServiceFactory;

    @Mock
    private List<SignatureService> signatureServices;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateServiceSignatureTypeSupported() {
        SignatureService signatureService = mock(SignatureService.class);
        when(signatureService.getSignatureType()).thenReturn(SignatureType.JADES);
        when(signatureServices.stream()).thenReturn(List.of(signatureService).stream());

        SignatureService result = signatureServiceFactory.createService(SignatureType.JADES);
        assertEquals(signatureService, result);
    }

    @Test
    void testCreateServiceSignatureTypeNotSupported() {
        SignatureService signatureService = mock(SignatureService.class);
        when(signatureServices.stream()).thenReturn(List.of(signatureService).stream());

        try {
            signatureServiceFactory.createService(SignatureType.JADES);
        } catch (SignatureTypeNotSupportedException e) {
            assertEquals("Signature type: JADES is currently not supported", e.getMessage());
        }
    }


}