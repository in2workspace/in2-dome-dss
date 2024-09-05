//package es.in2.dss.api.exception;
//
//import es.in2.dss.z.exception.SignatureTypeNotSupportedException;
//import es.in2.dss.z.model.GenericResponseError;
//import es.in2.dss.z.util.SignatureErrorCodes;
//import es.in2.dss.z.model.SignatureResponseError;
//import es.in2.dss.z.exception.handler.GlobalControllerExceptionHandler;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.context.request.WebRequest;
//
//import java.util.Objects;
//
//import static es.in2.dss.z.exception.handler.GlobalControllerExceptionHandler.DEFAULT_ERROR_MESSAGE;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension .class)
//class GlobalControllerExceptionHandlerTest {
//
//    @InjectMocks
//    private GlobalControllerExceptionHandler exceptionHandler;
//
//    @Mock
//    private WebRequest webRequest;
//
//
//    @Test
//    void testHandleSignatureTypeNotSupportedException() {
//        SignatureTypeNotSupportedException exception = new SignatureTypeNotSupportedException("UnsupportedType");
//
//        ResponseEntity<SignatureResponseError> responseEntity = exceptionHandler.handleValidateDocumentExceptionException(exception);
//
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
//        SignatureResponseError errorResponse = responseEntity.getBody();
//        assertEquals(SignatureErrorCodes.SIGNATURE_TYPE_NOT_SUPPORTED, Objects.requireNonNull(errorResponse).error());
//        assertEquals("Signature type: UnsupportedType is currently not supported", errorResponse.description());
//    }
//
//    @Test
//    void testHandleGenericException() {
//        Exception exception = new Exception("Something went wrong");
//        when(webRequest.getDescription(anyBoolean())).thenReturn("Request description");
//
//        ResponseEntity<GenericResponseError> responseEntity = exceptionHandler.handleException(exception, webRequest);
//
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
//        GenericResponseError errorResponse = responseEntity.getBody();
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), Objects.requireNonNull(errorResponse).status());
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), errorResponse.error());
//        assertEquals("Something went wrong", errorResponse.message());
//        verify(webRequest, times(1)).getDescription(false);
//    }
//
//    @Test
//    void testHandleGenericExceptionDefaultErrorMessage() {
//        Exception exception = new Exception();
//        when(webRequest.getDescription(anyBoolean())).thenReturn(DEFAULT_ERROR_MESSAGE);
//
//        ResponseEntity<GenericResponseError> responseEntity = exceptionHandler.handleException(exception, webRequest);
//
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
//        GenericResponseError errorResponse = responseEntity.getBody();
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), Objects.requireNonNull(errorResponse).status());
//        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), errorResponse.error());
//        assertEquals("An error occurred", errorResponse.message());
//        verify(webRequest, times(1)).getDescription(false);
//    }
//}
