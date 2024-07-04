package es.in2.remotesignature.controllers;

import es.in2.remotesignature.dtos.SignatureConfiguration;
import es.in2.remotesignature.dtos.SignatureRequest;
import es.in2.remotesignature.dtos.SignedData;
import es.in2.remotesignature.enums.SignatureType;
import es.in2.remotesignature.services.SignatureService;
import es.in2.remotesignature.services.SignatureServiceFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SignatureControllerTest {
    private SignatureController signatureController;

    @Mock
    private SignatureServiceFactory signatureServiceFactory;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        signatureController = new SignatureController(signatureServiceFactory);
    }

    @Test
    void testSign()  {
        SignatureRequest request = new SignatureRequest(new SignatureConfiguration(SignatureType.JADES, null), "");
        SignedData signedData = new SignedData();

        // Mock the behavior of the SignatureServiceFactory and SignatureService
        SignatureService signatureService = mock(SignatureService.class);
        SignatureType signatureType = SignatureType.JADES;
        when(signatureServiceFactory.createService(signatureType)).thenReturn(signatureService);
        when(signatureService.sign(request)).thenReturn(signedData);

        ResponseEntity<SignedData> responseEntity = signatureController.sign(request);

        assertEquals(200, responseEntity.getStatusCodeValue());

        assertEquals(signedData, responseEntity.getBody());

        verify(signatureServiceFactory, times(1)).createService(signatureType);

        verify(signatureService, times(1)).sign(request);
    }
}
