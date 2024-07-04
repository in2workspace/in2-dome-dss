package es.in2.remotesignature.exceptions;

import es.in2.remotesignature.dtos.errors.GenericResponseError;
import es.in2.remotesignature.dtos.errors.SignatureErrorCodes;
import es.in2.remotesignature.dtos.errors.SignatureResponseError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static es.in2.remotesignature.exceptions.GlobalControllerExceptionHandler.DEFAULT_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;

class GlobalControllerExceptionHandlerTest {

    @InjectMocks
    private GlobalControllerExceptionHandler exceptionHandler;

    @Mock
    private WebRequest webRequest;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testHandleSignatureTypeNotSupportedException() {
        SignatureTypeNotSupportedException exception = new SignatureTypeNotSupportedException("UnsupportedType");

        ResponseEntity<SignatureResponseError> responseEntity = exceptionHandler.handleValidateDocumentExceptionException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        SignatureResponseError errorResponse = responseEntity.getBody();
        assertEquals(SignatureErrorCodes.SIGNATURE_TYPE_NOT_SUPPORTED, errorResponse.getError());
        assertEquals("Signature type: UnsupportedType is currently not supported", errorResponse.getDescription());
    }

    @Test
    void testHandleGenericException() {
        Exception exception = new Exception("Something went wrong");
        when(webRequest.getDescription(anyBoolean())).thenReturn("Request description");

        ResponseEntity<GenericResponseError> responseEntity = exceptionHandler.handleException(exception, webRequest);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        GenericResponseError errorResponse = responseEntity.getBody();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorResponse.getStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), errorResponse.getError());
        assertEquals("Something went wrong", errorResponse.getMessage());
        verify(webRequest, times(1)).getDescription(false);
    }

    @Test
    void testHandleGenericExceptionDefaultErrorMessage() {
        Exception exception = new Exception();
        when(webRequest.getDescription(anyBoolean())).thenReturn(DEFAULT_ERROR_MESSAGE);

        ResponseEntity<GenericResponseError> responseEntity = exceptionHandler.handleException(exception, webRequest);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        GenericResponseError errorResponse = responseEntity.getBody();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorResponse.getStatus());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), errorResponse.getError());
        assertEquals("An error occurred", errorResponse.getMessage());
        verify(webRequest, times(1)).getDescription(false);
    }
}
