//package es.in2.dss.api.controller;
//
//import es.in2.dss.z.model.SignatureConfiguration;
//import es.in2.dss.z.model.SignatureRequest;
//import es.in2.dss.z.model.SignedData;
//import es.in2.dss.z.model.SignatureType;
//import es.in2.dss.z.service.SignatureService;
//import es.in2.dss.z.service.SignatureServiceFactory;
//import es.in2.dss.controller.SignaturesController;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class SignaturesControllerTest {
//    private SignaturesController signaturesController;
//
//    @Mock
//    private SignatureServiceFactory signatureServiceFactory;
//
//    @BeforeEach
//    public void setUp() {
//        signaturesController = new SignaturesController(signatureServiceFactory);
//    }
//
//    @Test
//    void testSign()  {
//        SignatureRequest request = SignatureRequest.builder()
//                .configuration(SignatureConfiguration.builder()
//                        .type(SignatureType.JADES)
//                        .parameters(null)
//                        .build())
//                .data("")
//                .build();
//        SignedData signedData = SignedData.builder().build();
//
//        // Mock the behavior of the SignatureServiceFactory and SignatureService
//        SignatureService signatureService = mock(SignatureService.class);
//        SignatureType signatureType = SignatureType.JADES;
//        when(signatureServiceFactory.createService(signatureType)).thenReturn(signatureService);
//        when(signatureService.sign(request)).thenReturn(signedData);
//
//        ResponseEntity<SignedData> responseEntity = signaturesController.sign(request);
//
//        assertEquals(200, responseEntity.getStatusCode().value());
//
//        assertEquals(signedData, responseEntity.getBody());
//
//        verify(signatureServiceFactory, times(1)).createService(signatureType);
//
//        verify(signatureService, times(1)).sign(request);
//    }
//}
