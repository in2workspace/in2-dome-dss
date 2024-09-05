//package es.in2.dss.api.service;
//
//import es.in2.dss.z.model.SignatureType;
//import es.in2.dss.z.exception.SignatureTypeNotSupportedException;
//import es.in2.dss.z.service.SignatureService;
//import es.in2.dss.z.service.impl.SignatureServiceFactoryImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class SignatureServiceFactoryImplTest {
//    @InjectMocks
//    private SignatureServiceFactoryImpl signatureServiceFactory;
//
//    @Mock
//    private List<SignatureService> signatureServices;
//
//
//    @Test
//    void testCreateServiceSignatureTypeSupported() {
//        SignatureService signatureService = mock(SignatureService.class);
//        when(signatureService.getSignatureType()).thenReturn(SignatureType.JADES);
//        when(signatureServices.stream()).thenReturn(Stream.of(signatureService));
//        SignatureService result = signatureServiceFactory.createService(SignatureType.JADES);
//        assertEquals(signatureService, result);
//    }
//
//    @Test
//    void testCreateServiceSignatureTypeNotSupported() {
//        SignatureService signatureService = mock(SignatureService.class);
//        when(signatureServices.stream()).thenReturn(Stream.of(signatureService));
//        try {
//            signatureServiceFactory.createService(SignatureType.JADES);
//        } catch (SignatureTypeNotSupportedException e) {
//            assertEquals("Signature type: JADES is currently not supported", e.getMessage());
//        }
//    }
//
//}
